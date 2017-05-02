package com.chm.shop.app.interceptor;


import com.chm.shop.app.constant.UrlRightConstant;
import com.chm.shop.app.util.CookieUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * Created by zhuhai on 2015/6/25.
 */
public class OperateInterceptor extends HandlerInterceptorAdapter {
    private static final Logger logger = LoggerFactory.getLogger(OperateInterceptor.class);


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
        throws Exception {
        String url = request.getRequestURL().toString();

        //忽略所有验证
        for (String notVerifyUrl : UrlRightConstant.notVerifyUrlList) {
            if (url.indexOf(notVerifyUrl) != -1) {
                return true;
            }
        }

        //判断用户是否登陆，如果没有则跳转到登陆页面
        String userId = CookieUtils.getCookie(request,"userId");
//        if (StringUtils.isEmpty(userId)) {
//            logger.info("没有cookie重新登录");
//            response.sendRedirect("/login");
//            return false;
//        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {
        if (null != modelAndView) {
            String userId = CookieUtils.getCookie(request,"userId");
            String userName = CookieUtils.getCookie(request,"userName");
            modelAndView.addObject("userId",userId);
            modelAndView.addObject("userName",userName);

        }
        super.postHandle(request, response, handler, modelAndView);
    }
}
