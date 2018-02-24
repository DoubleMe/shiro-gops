package com.chm.shop.app.util;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

/**
 * @author chen-hongmin
 * @since 2017/11/10 10:50
 */
public class Md5Utils {
    /**
     * 编码格式
     */
    private static String encoding = "utf-8";

    /**
     * MD5加密
     *
     * @param data
     * @return
     * @throws Exception
     */
    public static String getMD5(String data){
        byte[] bytes = new byte[0];
        String md5 = null;
        try {
            bytes = data.getBytes(encoding);
            md5  = getMD5(bytes);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }catch (NoSuchAlgorithmException e){
            e.printStackTrace();
        }
        return md5;
    }

    /**
     * MD5加密
     *
     * @param src
     * @return
     * @throws NoSuchAlgorithmException
     */
    public static String getMD5(byte[] src) throws NoSuchAlgorithmException {
        StringBuffer sb = new StringBuffer();

        java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");
        md.update(src);
        for (byte b : md.digest()){
            sb.append(Integer.toString(b >>> 4 & 0xF, 16)).append(Integer.toString(b & 0xF, 16));
        }

        return sb.toString();
    }

    public static String encrypt(String data) {
        try {
            byte[] bytes = data.getBytes(encoding);
            return getMD5(bytes);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
