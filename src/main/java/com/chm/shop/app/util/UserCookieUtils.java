package com.chm.shop.app.util;

import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by yuwen on 2017/5/25.
 */
public class UserCookieUtils {

    public static boolean isAdminLogin(HttpServletRequest request){

        String userId = CookieUtils.getCookie(request,"adminUserId");
        return !StringUtils.isEmpty(userId);
    }
}
