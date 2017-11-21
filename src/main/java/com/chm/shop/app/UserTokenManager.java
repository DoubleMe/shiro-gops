package com.chm.shop.app;

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
    public static UserToken getUserToken() {

        Object userToken = SecurityUtils.getSubject().getPrincipal();

        if (userToken == null){
            return null;
        }
        return (UserToken)userToken;
    }


    /**
     * 获取当前用户登录ID
     * @return
     */
    public static String getLoginId() {

        UserToken userDO = getUserToken();

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

        UserToken userDO = getUserToken();

        if (userDO != null) {
            return userDO.getUserId();
        }
        return null;
    }

    /**
     * 获取当前用户登录ID
     * @return
     */
    public static String getUserRole() {

        UserToken userDO = getUserToken();

        if (userDO != null) {
            return userDO.getRole();
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
