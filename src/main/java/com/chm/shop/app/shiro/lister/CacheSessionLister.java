package com.chm.shop.app.shiro.lister;

import com.chm.shop.app.UserTokenManager;
import com.chm.shop.app.cache.CommonCacheManager;
import com.chm.shop.app.cache.RedisKeys;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.SessionListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import java.io.Serializable;
import java.util.Deque;

/**
 * @author chen-hongmin
 * @since 2017/11/2 9:35
 */
public class CacheSessionLister implements SessionListener {

    private final static Logger LOGGER = LoggerFactory.getLogger(CacheSessionLister.class);

    private CommonCacheManager commonCacheManager;

    @Override
    public void onStart(Session session) {

    }

    @Override
    public void onStop(Session session) {

    }

    @Override
    public void onExpiration(Session session) {

        String loginId = UserTokenManager.getLoginId();
        if (!StringUtils.isEmpty(loginId)) {

            String key = RedisKeys.getOnlineUserKey(loginId);
            Deque<Serializable> queue = (Deque<Serializable>) commonCacheManager.getValue(key);

            queue.remove(session.getId());
            if (queue != null) {
                commonCacheManager.setValue(key,queue);
            }
            LOGGER.info("用户{},sessionId = {} 过期",loginId ,session.getId());
        }
    }

    public CommonCacheManager getCommonCacheManager() {
        return commonCacheManager;
    }

    public void setCommonCacheManager(CommonCacheManager commonCacheManager) {
        this.commonCacheManager = commonCacheManager;
    }
}
