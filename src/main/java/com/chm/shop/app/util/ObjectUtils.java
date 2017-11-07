package com.chm.shop.app.util;

/**
 * @author chen-hongmin
 * @since 2017/10/27 10:25
 */
public class ObjectUtils {

    public static boolean isNull(Object obj){

        return obj == null;
    }

    public static boolean equels(Object obj1,Object obj2){

        if (obj1 == null && obj2 == null){
            return true;
        }
        if (obj1 == null && obj2 != null){
            return false;
        }
        if (obj1 != null && obj2 == null){
            return false;
        }

        return obj1.equals(obj2);
    }
}
