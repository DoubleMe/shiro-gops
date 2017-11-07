package com.chm.shop.manager.user.impl;

import com.chm.shop.app.common.reponse.PageResponse;
import com.chm.shop.app.common.reponse.Response;
import com.chm.shop.app.common.reponse.ResponseCode;
import com.chm.shop.app.constants.MessageConstats;
import com.chm.shop.app.util.PageUtils;
import com.chm.shop.app.util.ResponseUtils;
import com.chm.shop.manager.menu.dataobject.MenuDO;
import com.chm.shop.manager.menu.query.MenuQuery;
import com.chm.shop.manager.user.UserService;
import com.chm.shop.manager.user.dataobject.UserDO;
import com.chm.shop.manager.user.query.UserQuery;
import com.chm.shop.manager.userrole.dataobject.UserRoleDO;
import com.chm.shop.mapper.*;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author chen-hongmin
 * @since 2017/10/31 13:24
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;
    @Resource
    private RoleMenuMapper roleMenuMapper;
    @Resource
    private UserRoleMapper userRoleMapper;


    @Override
    public PageResponse<UserDO> list(UserQuery userQuery) {

        PageList<UserDO> userDOS = userMapper.list(userQuery, new PageBounds(userQuery.getPage(), userQuery.getSize()));
        return ResponseUtils.pageResponse(ResponseCode.SUCCESS, "成功", userDOS);
    }

    @Override
    public Response<UserDO> register(UserDO userDO) {

        userMapper.insert(userDO);
        return ResponseUtils.successResponse(userDO, "新增成功");
    }

    @Override
    public UserDO getByLoginId(String loginId) {

        return userMapper.getByLoginId(loginId);
    }

    @Override
    public Response<List<MenuDO>> listMenu(Long userId) {

        UserRoleDO userRoleDO = userRoleMapper.getByUserId(userId);
        if (null == userRoleDO) {
            return ResponseUtils.failResponse(MessageConstats.FAIL);
        }
        List<MenuDO> menuDOS = roleMenuMapper.listMenu(userRoleDO.getRoleId());
        return ResponseUtils.successResponse(menuDOS, MessageConstats.SUCCESS);
    }
}
