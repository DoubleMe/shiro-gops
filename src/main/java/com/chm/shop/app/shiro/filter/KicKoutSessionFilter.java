package com.chm.shop.app.shiro.filter;

import com.chm.shop.app.UserToken;
import com.chm.shop.app.cache.SessionIdCacheManager;
import com.chm.shop.app.constants.CommonConstants;
import com.chm.shop.app.cache.BaseCache;
import com.chm.shop.app.cache.RedisKeys;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.DefaultSessionKey;
import org.apache.shiro.session.mgt.SessionManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.AccessControlFilter;
import org.apache.shiro.web.util.WebUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.Serializable;
import java.util.Deque;

/**
 * @author chen-hongmin
 * @since 2017/11/1 11:04
 */
public class KicKoutSessionFilter extends AccessControlFilter {

    private final static Logger LOGGER = LoggerFactory.getLogger(KicKoutSessionFilter.class);

    //踢出后到的地址
    private String kickoutUrl;

    private SessionIdCacheManager sessionIdCacheManager;

    private SessionManager sessionManager;

    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) throws Exception {


        Subject subject = getSubject(request, response);
        Session session = subject.getSession();
        //未登录,执行后续步骤
        if (!subject.isAuthenticated() && !subject.isRemembered()) {
            return Boolean.TRUE;
        }

        //被踢出用户直接执行后续步骤
        Boolean marker = (Boolean) session.getAttribute(CommonConstants.KICKOUT_STATUS);
        if (marker != null && marker) {

            UserToken userToken = (UserToken) subject.getPrincipal();

            LOGGER.info("用户{}被踢出", userToken.getLoginId());
            WebUtils.getSavedRequest(request);
            //再重定向
            WebUtils.issueRedirect(request, response, kickoutUrl);

            return Boolean.FALSE;
        }

        return Boolean.TRUE;
    }

    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {

        return Boolean.TRUE;
    }

    public String getKickoutUrl() {
        return kickoutUrl;
    }

    public void setKickoutUrl(String kickoutUrl) {
        this.kickoutUrl = kickoutUrl;
    }

    public SessionIdCacheManager getSessionIdCacheManager() {
        return sessionIdCacheManager;
    }

    public void setSessionIdCacheManager(SessionIdCacheManager sessionIdCacheManager) {
        this.sessionIdCacheManager = sessionIdCacheManager;
    }

    public SessionManager getSessionManager() {
        return sessionManager;
    }

    public void setSessionManager(SessionManager sessionManager) {
        this.sessionManager = sessionManager;
    }
}
