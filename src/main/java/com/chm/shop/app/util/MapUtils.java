package com.chm.shop.app.util;

import java.util.Map;

/**
 * @author chen-hongmin
 * @since 2017/11/8 16:35
 */
public class MapUtils {

    public static void removeKeys(Map<Object,Object> map, Object ...keys){

        if (keys != null && keys.length > 0){
            for (Object key :keys){
                map.remove(key);
            }
        }
    }
}
