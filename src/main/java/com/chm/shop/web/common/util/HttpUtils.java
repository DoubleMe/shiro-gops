package com.chm.shop.web.common.util;

import com.chm.shop.web.common.interceptor.ExceptionResolver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author chen-hongmin
 * @since 2017/11/2 16:37
 */
public class HttpUtils {

    private static final Logger LOGGER = LoggerFactory.getLogger(ExceptionResolver.class);

    /**
     * 是否是Ajax请求
     * @param request
     * @return
     */
    public static boolean isAjax(ServletRequest request){
        return "XMLHttpRequest".equalsIgnoreCase(((HttpServletRequest) request).getHeader("X-Requested-With"));
    }

    /**
     * response 输出JSON
     * @param response
     * @param outMsg
     * @throws IOException
     */
    public static void response(ServletResponse response, String outMsg){

        PrintWriter out = null;
        try {
            response.setCharacterEncoding("UTF-8");
            out = response.getWriter();
            out.println(outMsg);
        } catch (Exception e) {
            LOGGER.error("输出response 错误",e);
        }finally{
            if(null != out){
                out.flush();
                out.close();
            }
        }
    }
}
