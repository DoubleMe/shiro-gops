package com.chm.shop.app.util;

import org.apache.shiro.codec.Base64;
import org.springframework.util.Base64Utils;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.security.SecureRandom;

/**
 * AES base64 加解密
 * Created by chen-hongmin on 2017/7/12.
 */
public class AESUtils {


    /**
     * AES 加密
     *
     * @param originData 需要加密的内容
     * @param key        加密秘钥
     * @return
     * @throws Exception
     */
    public static String encrypt(String originData, String key) throws Exception {

        KeyGenerator kgen = KeyGenerator.getInstance("AES");
        SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");
        secureRandom.setSeed(key.getBytes("utf-8"));
        kgen.init(128, secureRandom);
        SecretKey secretKey = kgen.generateKey();

        byte[] enCodeFormat = secretKey.getEncoded();
        SecretKeySpec keySpec = new SecretKeySpec(enCodeFormat, "AES");
        // 创建密码器
        Cipher cipher = Cipher.getInstance("AES");

        byte[] byteContent = originData.getBytes("utf-8");
        cipher.init(Cipher.ENCRYPT_MODE, keySpec);// 初始化
        byte[] result = cipher.doFinal(byteContent);

        String encodeStr = new String(Base64Utils.encode(result));
        return encodeStr;

    }

    /**
     * 解密
     *
     * @param content 待解密内容
     * @param key     解密密钥
     * @return
     */
    public static String decrypt(String content, String key) throws Exception {

        KeyGenerator kgen = KeyGenerator.getInstance("AES");
        SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");
        secureRandom.setSeed(key.getBytes("utf-8"));
        kgen.init(128, secureRandom);
        SecretKey secretKey = kgen.generateKey();
        byte[] enCodeFormat = secretKey.getEncoded();
        SecretKeySpec keySpec = new SecretKeySpec(enCodeFormat, "AES");
        Cipher cipher = Cipher.getInstance("AES");// 创建密码器
        cipher.init(Cipher.DECRYPT_MODE, keySpec);// 初始化
        byte[] byteContent = Base64Utils.decodeFromString(content);
        byte[] result = cipher.doFinal(byteContent);
        String AES_decode = new String(result, "utf-8");
        return AES_decode;

    }


    public static void main(String[] args) throws Exception {


        String data = "undRDxUe0+ZXStQZLhK4UKfgtcVqrD8DVShrpH/LXNsxIBBZu/IjH4QrSh8v6B5ssicix+JTvQxGuEFfSQDAY27Anc2JqMvaSVzeekYd0xkwzLcrNsHXKsRo2677F1ar2sWzCkZQcOgYjN6oUDcTh3WdTApUE0UYegTNSYKIGfPRdHzNS7ULmg+lR3eVcsF16aO8IQ3nkQOEkwMNjh296vLqnfazkG00DKzkoUXFMyPWYv2XMXqZn+xm6ot4IKGS9RE5qvoNpKkJPbRGbETYGWXa2n+2XF/nIDSY+AvMq9orKwOh3W5KJDsjK3w102dzStd3cdzYRp2Cltwa0bV+x2MEAOrzuGjmPBpasjSQYRjxM7gSlcBzllZSaiD06sCeM5bnxkjVDroWIW4ZpjSYZUsylAdgFK3lJ9TIKGtGQxiNlGlHw3q+iDbD1DvqCywoVDCbdLard+VlP2J/RLohWvQiia5F0YcPzHfpvkktuYFVJELdUeBC2faSL6uYlxWyGEKeG7Q7cfZ4YWN8LY+R5R47iTGI2LNWc2P7/dkI9u4=";

        String decode = Base64.decodeToString(data);

        String key = Base64.decodeToString("3AvVhmFLUs0KTA3Kprsdag==");

        String decrypt = decrypt(decode, key);
        System.out.println(decrypt);


    }
}
