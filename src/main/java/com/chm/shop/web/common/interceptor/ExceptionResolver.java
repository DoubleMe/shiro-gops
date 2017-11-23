package com.chm.shop.web.common.interceptor;


import com.chm.shop.app.UserTokenManager;
import com.chm.shop.app.constants.IndexViewConstats;
import com.chm.shop.app.util.JsonUtils;
import com.chm.shop.app.util.ResponseUtils;
import com.chm.shop.web.common.exception.ParamValidException;
import com.chm.shop.web.common.util.HttpUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * @author chen-hongmin
 * @Type ExceptionResolver
 * @Desc 异常拦截器
 */
public class ExceptionResolver implements HandlerExceptionResolver {


    private static final Logger LOGGER = LoggerFactory.getLogger(ExceptionResolver.class);

    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
                                         Exception ex) {
        String exceptionLog = getExceptionLog(request);

        LOGGER.error(exceptionLog, ex);

        String errorMsg = "系统异常";
        if (ex instanceof ParamValidException){
            errorMsg = ex.getMessage();
        }
        if (HttpUtils.isAjax(request)){

            HttpUtils.response(response, JsonUtils.ObjToJson(ResponseUtils.failResponse(errorMsg)));

            return null;
        }else {
            ModelAndView modelAndView = new ModelAndView();
            modelAndView.setViewName(IndexViewConstats.ERROR_VIEW);

            return modelAndView;
        }
    }

    /**
     * 打印 错误日志
     *
     * @param request
     */
    private String getExceptionLog(HttpServletRequest request) {

        // url地址
        String url = request.getRequestURL().toString();
        //获取请求方的IP地址
        String remoteIp = request.getHeader("X-Real-IP");
        if (StringUtils.isEmpty(remoteIp)) {
            remoteIp = request.getRemoteAddr();
        }
        String loginId = UserTokenManager.getLoginId();
        // 打印日志
        StringBuilder errorLog = new StringBuilder();
        errorLog.append("\n<log>\n");
        errorLog.append("loginID=").append(loginId).append(";\n");
        errorLog.append("url=").append(url).append(";\n");
        errorLog.append("remoteIp=").append(remoteIp).append(";\n");
        errorLog.append("</log>\n");
        return ("请求异常：" + errorLog.toString());
    }
}
