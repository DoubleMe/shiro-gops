package com.chm.shop.app.cache;

/**
 * Redis所有Keys
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2017-07-18 19:51
 */
public class RedisKeys {

    public static String getSysConfigKey(String key) {
        return "sys:config:" + key;
    }

    public static String getShiroSessionKey(String key) {
        return "sessionid:" + key;
    }

    public static String getOnlineUserKey(String key) {
        return "online:user:" + key;
    }

    public static String getMenuKey(String key) {
        return "menu:" + key;
    }

    public static String getCurrMenuKey(String key) {
        return "curr:menu:" + key;
    }
}
