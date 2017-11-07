package com.chm.shop.app.shiro.filter;

import com.chm.shop.app.constants.CommonConstants;
import com.chm.shop.app.cache.CommonCacheManager;
import com.chm.shop.app.cache.RedisKeys;
import com.chm.shop.manager.user.dataobject.UserDO;
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
import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author chen-hongmin
 * @since 2017/11/1 11:04
 */
public class KicKoutSessionFilter extends AccessControlFilter {

    private final static Logger LOGGER = LoggerFactory.getLogger(KicKoutSessionFilter.class);

    //踢出后到的地址
    private String kickoutUrl;

    //踢出之前登录的/之后登录的用户 默认踢出之前登录的用户
    private boolean kickoutAfter = true;

    //同一个帐号最大会话数 默认1
    private int maxSession = 1;


    private CommonCacheManager commonCacheManager;

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
            return Boolean.FALSE;
        }
        UserDO userDO = (UserDO) subject.getPrincipal();
        String key = RedisKeys.getOnlineUserKey(userDO.getLoginId());
        commonCacheManager.delete(key);
        Deque<Serializable> queue = (Deque<Serializable>) commonCacheManager.getValue(key);
        //该账号第一次登陆
        if (queue == null) {
            queue = new ArrayDeque<>();
        }
        //队列中不包含该sessionId
        if (!queue.contains(session.getId())) {
            queue.add(session.getId());
        }
        commonCacheManager.setValue(key, queue);

        //当队列大于 最大session数,踢出用户
        while (queue.size() > maxSession) {
            Serializable kickoutSessionId = null;
            if (kickoutAfter) { //如果踢出后者
                kickoutSessionId = queue.removeFirst();
            } else { //否则踢出前者
                kickoutSessionId = queue.removeLast();
            }

            //获取需要被踢出用户session
            Session kickoutSession = sessionManager.getSession(new DefaultSessionKey(kickoutSessionId));
            if (kickoutSession != null) {
                //设置会话的kickout属性表示踢出了
                kickoutSession.setAttribute(CommonConstants.KICKOUT_STATUS, true);
            }
        }
        return Boolean.TRUE;
    }

    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {

        Subject subject = getSubject(request, response);
        Session session = subject.getSession();
        //被踢出用户直接执行后续步骤
        Boolean marker = (Boolean) session.getAttribute(CommonConstants.KICKOUT_STATUS);
        if (marker == null || !marker) {
            return Boolean.TRUE;
        }
        UserDO userDO = (UserDO) subject.getPrincipal();

        LOGGER.info("用户{}被踢出", userDO.getLoginId());
        WebUtils.getSavedRequest(request);
        //再重定向
        WebUtils.issueRedirect(request, response, kickoutUrl);
        return Boolean.FALSE;
    }

    public String getKickoutUrl() {
        return kickoutUrl;
    }

    public void setKickoutUrl(String kickoutUrl) {
        this.kickoutUrl = kickoutUrl;
    }

    public boolean isKickoutAfter() {
        return kickoutAfter;
    }

    public void setKickoutAfter(boolean kickoutAfter) {
        this.kickoutAfter = kickoutAfter;
    }

    public int getMaxSession() {
        return maxSession;
    }

    public void setMaxSession(int maxSession) {
        this.maxSession = maxSession;
    }

    public CommonCacheManager getCommonCacheManager() {
        return commonCacheManager;
    }

    public void setCommonCacheManager(CommonCacheManager commonCacheManager) {
        this.commonCacheManager = commonCacheManager;
    }

    public SessionManager getSessionManager() {
        return sessionManager;
    }

    public void setSessionManager(SessionManager sessionManager) {
        this.sessionManager = sessionManager;
    }
}
