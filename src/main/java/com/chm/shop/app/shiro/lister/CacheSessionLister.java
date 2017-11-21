package com.chm.shop.app.shiro.lister;

import com.chm.shop.app.cache.BaseCache;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.SessionListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author chen-hongmin
 * @since 2017/11/2 9:35
 */
public class CacheSessionLister implements SessionListener {

    private final static Logger LOGGER = LoggerFactory.getLogger(CacheSessionLister.class);

    private BaseCache commonCacheManager;

    @Override
    public void onStart(Session session) {
        System.out.println(session.getId() + "onStart");
    }

    @Override
    public void onStop(Session session) {

        System.out.println(session.getId() + "onStop");
    }

    @Override
    public void onExpiration(Session session) {

    }

    public BaseCache getCommonCacheManager() {
        return commonCacheManager;
    }

    public void setCommonCacheManager(BaseCache commonCacheManager) {
        this.commonCacheManager = commonCacheManager;
    }
}
