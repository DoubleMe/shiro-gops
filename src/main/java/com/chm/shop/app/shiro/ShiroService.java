package com.chm.shop.app.shiro;

import com.chm.shop.app.common.reponse.Response;
import com.chm.shop.app.util.ResponseUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;



/**
 * @author chen-hongmin
 * @since 2017/10/26 10:08
 */
@Service
public class ShiroService {

    private static final Logger logger = LoggerFactory.getLogger(ShiroService.class);


    /**
     * 登陆
     *
     * @param userName
     * @param password
     * @return
     */
    public Response<String> login(String userName, String password , boolean rememberMe) {

        UsernamePasswordToken token = new UsernamePasswordToken(userName, password ,rememberMe);
        Subject subject = SecurityUtils.getSubject();
        try {
            //4、登录，即身份验证
            subject.login(token);
        } catch (AuthenticationException e) {
            e.printStackTrace();
            //5、身份验证失败
            return ResponseUtils.failResponse("用户名或密码错误!");
        }

        return ResponseUtils.successResponse("", "登陆成功!");
    }

}