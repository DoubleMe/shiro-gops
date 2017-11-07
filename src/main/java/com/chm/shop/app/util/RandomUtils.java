package com.chm.shop.app.util;

/**
 * @author chen-hongmin
 * @since 2017/10/30 16:42
 */
public class RandomUtils {


    private static String STRING = "abcdefghijklmnopqrstuvwxyz";


    /**
     * 获取随机字符串
     * @param length
     * @return
     */
    public static String randomStr(int length){
        StringBuffer sb = new StringBuffer();
        int len = STRING.length();
        for (int i = 0; i < length; i++) {
            sb.append(STRING.charAt(getRandom(len-1)));
        }
        return sb.toString();
    }

    /**
     * 获取随机数
     * @param count
     * @return
     */
    public static int getRandom(int count){
        return (int) Math.round(Math.random() * (count));
    }

}
