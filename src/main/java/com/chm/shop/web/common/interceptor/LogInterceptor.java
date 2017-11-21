package com.chm.shop.web.common.interceptor;


import com.chm.shop.app.UserTokenManager;
import com.chm.shop.app.common.anno.SysLog;
import com.chm.shop.app.thread.ThreadPoolHolder;
import com.chm.shop.manager.log.LogService;
import com.chm.shop.manager.log.dataobject.LogApiDO;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.apache.shiro.web.util.WebUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;

/**
 * Created by chen-hongmin on 2015/6/25.
 */
public class LogInterceptor implements MethodInterceptor {

    private static final Logger logger = LoggerFactory.getLogger("API");

    @Resource
    private HttpServletRequest request;


    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {

        Method method = invocation.getMethod();
        SysLog sysLog = method.getAnnotation(SysLog.class);
        if (sysLog != null){
            LogApiDO logApiDO = new LogApiDO();
            logApiDO.setLoginId(UserTokenManager.getLoginId());
            logApiDO.setMessage(sysLog.message());
            logApiDO.setModule(sysLog.module().getModule());
            logApiDO.setUri(WebUtils.getRequestUri(request));
            logApiDO.setMethod(request.getMethod());

            ThreadPoolHolder.apiLogManager.addQueue(logApiDO);
            if (logger.isDebugEnabled()){
                logger.debug(logApiDO.toString());
            }
        }
        return invocation.proceed();
    }

}
