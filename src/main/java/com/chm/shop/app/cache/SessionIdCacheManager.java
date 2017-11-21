package com.chm.shop.app.cache;

import java.io.Serializable;
import java.util.concurrent.TimeUnit;

/**
 * @author chen-hongmin
 * @since 2017/11/21 14:13
 */
public class SessionIdCacheManager extends BaseCache<String, Serializable> {


    public final static Long SESSION_TIME_OUT = 30 * 60L;

    public SessionIdCacheManager() {
        super();
    }


    /**
     * 设置缓存 默认过期时间
     *
     * @param key
     * @param value
     */
    public void setValue(String key, Serializable value) {

        template.opsForValue().set(key, value);
        template.expire(key, this.SESSION_TIME_OUT, TimeUnit.SECONDS);
    }

}
