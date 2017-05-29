package com.chm.shop.app.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * Created by chen-hongmin on 2017/4/30.
 */
public class CookieUtils {


    public static void addCookie(HttpServletResponse response, String key, String value){

        try {
            String va = URLEncoder.encode(value,"utf-8");
            Cookie cookie = new Cookie(key,va);
            response.addCookie(cookie);
        }catch (UnsupportedEncodingException e){
            e.printStackTrace();
        }
    }

    public static String getCookie(HttpServletRequest request, String key){

        Cookie[] cookies = request.getCookies();

        // 然后迭代之
        if (cookies != null && cookies.length > 0) { //如果没有设置过Cookie会返回null
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals(key)){
                    return cookie.getValue();

                }
            }
        }
        return null;
    }
}
