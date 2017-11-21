package com.chm.shop.app.shiro.filter;

import com.chm.shop.app.UserToken;
import com.chm.shop.app.UserTokenManager;
import com.chm.shop.app.cache.SessionIdCacheManager;
import com.chm.shop.app.constants.CommonConstants;
import com.chm.shop.app.cache.BaseCache;
import com.chm.shop.app.cache.RedisKeys;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.LogoutFilter;
import org.hibernate.SessionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.Serializable;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;

/**
 * @author chen-hongmin
 * @since 2017/10/31 18:01
 */
@Service
public class SystemLogoutFilter extends LogoutFilter {

    private final static Logger LOGGER = LoggerFactory.getLogger(SystemLogoutFilter.class);



    @Override
    protected boolean preHandle(ServletRequest request, ServletResponse response) throws Exception {
        //在这里执行退出系统前需要清空的数据
        Subject subject = getSubject(request, response);
        String redirectUrl = getRedirectUrl(request, response, subject);

        Session session = subject.getSession();
        //被踢出用户直接执行后续步骤
        Boolean marker = (Boolean) session.getAttribute(CommonConstants.KICKOUT_STATUS);
        //用户是被强制踢出
        if (marker != null && marker){
            redirectUrl  = kicKoutUrl(redirectUrl);
        }
        UserToken userDO = (UserToken) subject.getPrincipal();
//        Deque<Serializable> queue = (Deque<Serializable>)commonCacheManager.getValue(RedisKeys.getCurrUserKey(userDO.getLoginId()));
//        Serializable id = subject.getSession().getId();
//
//        if (queue != null){
//            queue.remove(id);
//        }
//        commonCacheManager.setValue(RedisKeys.getCurrUserKey(userDO.getLoginId()),queue);
//
//        Session session = subject.getSession();
//        //被踢出用户直接执行后续步骤
//        Boolean marker = (Boolean) session.getAttribute(CommonConstants.KICKOUT_STATUS);
//        //用户是被强制踢出
//        if (marker != null && marker){
//            redirectUrl  = kicKoutUrl(redirectUrl);
//        }else {
//            //退出时删除在线用户缓存
//            Object value = commonCacheManager.getValue(RedisKeys.getOnlineUserKey());
//            if (value != null){
//                List<UserToken> userTokenList = (List<UserToken>)value;
//                Iterator<UserToken> iterator = userTokenList.iterator();
//                while (iterator.hasNext()){
//                    UserToken userToken = iterator.next();
//                    if (userToken.getUserId().equals(UserTokenManager.getUserId())){
//                        iterator.remove();
//                    }
//                }
//                commonCacheManager.setValue(RedisKeys.getOnlineUserKey(),userTokenList);
//            }
//        }

        try {
            subject.logout();
        } catch (SessionException e) {
            LOGGER.info("用户退出异常,loginId = {},userName = {}",userDO.getLoginId(),userDO.getUserName(),e);
        }

        issueRedirect(request, response, redirectUrl);
        return false;
    }

    private String kicKoutUrl(String redirectUrl){

        return redirectUrl + "?" + CommonConstants.KICKOUT + "=1";
    }

}
