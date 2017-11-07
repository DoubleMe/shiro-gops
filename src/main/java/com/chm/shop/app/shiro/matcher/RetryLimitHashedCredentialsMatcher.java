package com.chm.shop.app.shiro.matcher;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;

/**
 * @author chen-hongmin
 * @since 2017/10/26 12:28
 */
public class RetryLimitHashedCredentialsMatcher extends HashedCredentialsMatcher {

//    // 缓存接口
//    @Resource
//    private CommonCacheManager commonCacheManager;


    @Override
    public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {
//        String username = (String) token.getPrincipal();
//        String retryCount = commonCacheManager.getString(username);
//        if (retryCount == null) {
//            retryCount = "1";
//            commonCacheManager.increment(username);
//        }
//        // 自定义一个验证过程：当用户连续输入密码错误5次以上禁止用户登录一段时间
//        if (Integer.valueOf(retryCount) > 5) {
//            throw new ExcessiveAttemptsException();
//        }
//        commonCacheManager.delete(username);
        return true;
    }
}
