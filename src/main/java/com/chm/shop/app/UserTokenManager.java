package com.chm.shop.app;

import com.chm.shop.manager.user.dataobject.UserDO;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;

/**
 * @author chen-hongmin
 * @since 2017/11/2 9:37
 */
public class UserTokenManager {


    /**
     * 获取当前用户
     *
     * @return
     */
    public static UserDO getUserToken() {

        UserDO userDO = (UserDO) SecurityUtils.getSubject().getPrincipal();

        return userDO;
    }


    /**
     * 获取当前用户登录ID
     * @return
     */
    public static String getLoginId() {

        UserDO userDO = (UserDO) SecurityUtils.getSubject().getPrincipal();

        if (userDO != null) {
            return userDO.getLoginId();
        }
        return null;
    }

    /**
     * 获取当前用户登录ID
     * @return
     */
    public static Long getUserId() {

        UserDO userDO = (UserDO) SecurityUtils.getSubject().getPrincipal();

        if (userDO != null) {
            return userDO.getId();
        }
        return null;
    }
    /**
     * 获取当前用户的Session
     *
     * @return
     */
    public static Session getSession() {
        return SecurityUtils.getSubject().getSession();
    }
}
