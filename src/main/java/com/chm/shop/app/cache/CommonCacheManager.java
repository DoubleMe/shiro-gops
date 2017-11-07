package com.chm.shop.app.cache;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.concurrent.TimeUnit;

/**
 * @author alex
 * @Type CommonCacheManager
 * @Desc 通用缓存管理
 * @date 2014-6-11
 * @Version V1.0
 */
public class CommonCacheManager<K, V>{

    private RedisTemplate<K,V> template;
    /**
     * 默认过期时间： 24小时
     */
    private static final Long DEFAULT_EXPIRE = 24 * 60 * 60L;

    public CommonCacheManager() {

    }

    /**
     * 设置缓存及过期时间
     *
     * @param key
     * @param value
     * @param timeout
     */
    public void setValue(K key, V value, Long timeout) {
        if (timeout == null || timeout <= 0) {
            timeout = DEFAULT_EXPIRE;
        }
        template.opsForValue().set(key, value);
        template.expire(key, timeout, TimeUnit.SECONDS);
    }

    /**
     * 设置缓存 默认过期时间
     *
     * @param key
     * @param value
     */
    public void setValue(K key, V value) {

        template.opsForValue().set(key, value);
        template.expire(key, this.DEFAULT_EXPIRE, TimeUnit.SECONDS);
    }

    /**
     * 获取缓存
     *
     * @param key 键
     * @return 如果不存在或者已经过期，返回null
     */
    public V getValue(K key) {
        return template.opsForValue().get(key);
    }

    /**
     * 删除缓存
     *
     * @param key 键
     */
    public void delete(K key) {
        template.delete(key);
    }


    public RedisTemplate<K, V> getTemplate() {
        return template;
    }

    public void setTemplate(RedisTemplate<K, V> template) {
        this.template = template;
    }

}
