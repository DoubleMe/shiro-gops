/*
 * Project: guahao-portal-biz-core
 * 
 * File Created at 2012-5-21
 * 
 * Copyright 2012 Greenline.com Corporation Limited.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * Greenline Company. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Greenline.com.
 */
package com.chm.shop.app.cache;

import org.springframework.data.redis.core.BoundHashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.support.collections.RedisList;
import org.springframework.data.redis.support.collections.RedisSet;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @Type CacheBase
 * @Desc cache基类
 * @author weirui.shenwr
 * @date 2012-5-21
 * @Version V1.0
 */
public class CacheBase<K,V> {

    protected RedisTemplate<K,V> template;

    /**
     * 超时时间
     */
    private Long expireTime;

    /**
     * 超时时间
     */
    public Long getExpireTime() {
        return expireTime;
    }

    /**
     * 超时时间
     */
    public void setExpireTime(Long expireTime) {
        this.expireTime = expireTime;
    }

    public CacheBase(){
    	
    }
    
    /**
     * @param template
     */
    public CacheBase(RedisTemplate template) {
        this.template = template;
    }

    /**
     * 按默认过期时间设置内容
     * 
     * @param key
     * @param value
     */
    protected void setExpire(K key, V value) {
        if (this.getExpireTime() != null) {
            template.opsForValue().set(key, value, this.getExpireTime().longValue(), TimeUnit.SECONDS);
        } else {
            template.opsForValue().set(key, value);
        }
    }

    /**
     * 设置默认过期时间
     * 
     * @param ops
     */
    protected boolean setExpire(BoundHashOperations<String, String, String> ops) {
        if (this.getExpireTime() != null) {
            return ops.expire(this.getExpireTime().longValue(), TimeUnit.SECONDS);
        }
        return false;
    }

    /**
     * 设置默认过期时间
     * 
     * @param ops
     */
    protected boolean setExpire(RedisList<String> ops) {
        if (this.getExpireTime() != null) {
            return ops.expire(this.getExpireTime().longValue(), TimeUnit.SECONDS);
        }
        return false;
    }

    /**
     * 设置默认过期时间
     * 
     * @param ops
     */
    protected boolean setExpire(RedisSet<String> ops) {
        if (this.getExpireTime() != null) {
            return ops.expire(this.getExpireTime().longValue(), TimeUnit.SECONDS);
        }
        return false;
    }
}
