package com.chm.shop.app.shiro.realm;

import com.chm.shop.app.UserToken;
import com.chm.shop.app.UserTokenManager;
import com.chm.shop.app.cache.BaseCache;
import com.chm.shop.app.cache.RedisKeys;
import com.chm.shop.app.cache.SessionIdCacheManager;
import com.chm.shop.app.common.reponse.Response;
import com.chm.shop.app.constants.CommonConstants;
import com.chm.shop.app.util.Md5Utils;
import com.chm.shop.manager.menu.dataobject.MenuDO;
import com.chm.shop.manager.role.RoleService;
import com.chm.shop.manager.role.dataobject.RoleDO;
import com.chm.shop.manager.user.UserService;
import com.chm.shop.manager.user.dataobject.UserDO;
import com.chm.shop.manager.userrole.UserRoleService;
import com.chm.shop.manager.userrole.dataobject.UserRoleDO;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.DefaultSessionKey;
import org.apache.shiro.session.mgt.SessionManager;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.*;

/**
 * @author chen-hongmin
 * @since 2017/10/26 12:35
 */
public class UserRealm extends AuthorizingRealm {

    private final static Logger LOGGER = LoggerFactory.getLogger(UserRealm.class);

    @Resource
    private UserService userService;

    @Resource
    private UserRoleService userRoleService;

    @Resource
    private RoleService roleService;

    @Resource
    private SessionManager sessionManager;

    @Resource
    private SessionIdCacheManager sessionIdCacheManager;

    /**
     * 提供用户信息返回权限信息
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {

        Long userId = UserTokenManager.getUserId();
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        // 根据用户名查询当前用户拥有的角色
        Response<UserRoleDO> userRole = userRoleService.getByUserId(userId);
        if (userRole.getData() == null) {
            return authorizationInfo;
        }

        Response<RoleDO> response = roleService.getById(userRole.getData().getRoleId());
        if (response.getData() == null) {
            return authorizationInfo;
        }
        Set<String> roleNames = new HashSet<>();
        roleNames.add(response.getData().getSalt());
        // 将角色名称提供给info
        authorizationInfo.setRoles(roleNames);
        // 根据用户名查询当前用户权限
        Response<List<MenuDO>> listResponse = userService.listMenu(userId);

        if (listResponse.getData() == null) {
            return authorizationInfo;
        }
        Set<String> permissionNames = new HashSet<>();
        for (MenuDO menuDO : listResponse.getData()) {
            permissionNames.add(menuDO.getUrl());
        }
        // 将权限名称提供给info
        authorizationInfo.setStringPermissions(permissionNames);

        return authorizationInfo;
    }

    /**
     * 认证信息,主要针对用户登录
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        UsernamePasswordToken myToken = (UsernamePasswordToken) token;

        String username = myToken.getUsername();
        UserDO userDO = userService.getByLoginId(username);
        if (userDO == null) {
            throw new AccountException("帐号或密码不正确！");
        }

        String md5 = Md5Utils.getMD5(new String(myToken.getPassword()) + userDO.getSalt());

        if (!userDO.getPassword().equals(md5)) {
            throw new AccountException("帐号或密码不正确！");
        }
        UserToken userToken = new UserToken();
        userToken.setLoginId(userDO.getLoginId());
        userToken.setUserId(userDO.getId());
        userToken.setUserName(userDO.getUserName());
        userToken.setLoginTime(new Date());

        Response<UserRoleDO> response = userRoleService.getByUserId(userDO.getId());
        if (response.isSuccess() && response.getData() != null) {
            userToken.setRole(response.getData().getRoleId() + "");
        }

        //*********************************添加缓存**********************************
        String key = RedisKeys.getCurrUserKey(userDO.getLoginId());
        Serializable sessionId = sessionIdCacheManager.getValue(key);
        //之前有人登录
        if (sessionId != null) {
            Session oldSession = sessionManager.getSession(new DefaultSessionKey(sessionId));
            oldSession.setAttribute(CommonConstants.KICKOUT_STATUS, true);
        }
        sessionIdCacheManager.setValue(key, UserTokenManager.getSession().getId());

        //*********************************end*************************************

        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(userToken, new String(myToken.getPassword()), getName());

        LOGGER.info("用户{},登录成功", userToken.getLoginId());
        return authenticationInfo;
    }
}
