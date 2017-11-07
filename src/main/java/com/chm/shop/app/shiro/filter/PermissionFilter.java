package com.chm.shop.app.shiro.filter;

import com.chm.shop.app.UserTokenManager;
import com.chm.shop.app.constants.IndexViewConstats;
import com.chm.shop.app.util.JsonUtils;
import com.chm.shop.app.util.ResponseUtils;
import com.chm.shop.web.common.util.HttpUtils;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.AccessControlFilter;
import org.apache.shiro.web.util.WebUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

/**
 * @author chen-hongmin
 * @since 2017/11/6 15:58
 */
public class PermissionFilter extends AccessControlFilter {

    private final static Logger LOGGER = LoggerFactory.getLogger(PermissionFilter.class);

    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) throws Exception {
        //先判断带参数的权限判断
        Subject subject = getSubject(request, response);
        String uri = WebUtils.getRequestUri((HttpServletRequest)request);
        if(!subject.isPermitted(uri)){
            LOGGER.info("没有权限 login ={} , url= {}", UserTokenManager.getLoginId(),uri);
            if (HttpUtils.isAjax(request)){
                HttpUtils.response(response , JsonUtils.ObjToJson(ResponseUtils.failResponse("没有权限")));
            }else {
                WebUtils.issueRedirect(request,response, IndexViewConstats.NO_PERMISSION_VIEW);
            }
            return false;
        }
        LOGGER.info("用户 {} ,正常访问 {}", UserTokenManager.getLoginId(),uri);
        return true;
    }

    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
        return true;
    }
}
