package com.chm.shop.app.shiro;

import com.chm.shop.app.cache.RedisKeys;
import org.apache.shiro.codec.Base64;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.UnknownSessionException;
import org.apache.shiro.session.mgt.eis.AbstractSessionDAO;
import org.apache.shiro.session.mgt.eis.EnterpriseCacheSessionDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Collection;
import java.util.concurrent.TimeUnit;

/**
 * shiro session dao
 *
 * @author chenshun
 * @date 2017/9/27 21:35
 */
@Component
public class RedisShiroSessionDAO extends AbstractSessionDAO {
    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public void update(Session session) throws UnknownSessionException {
        setShiroSession(session.getId().toString(),session);
    }

    @Override
    public void delete(Session session) {
        final String key = RedisKeys.getShiroSessionKey(session.getId().toString());
        redisTemplate.delete(key);
    }

    @Override
    public Collection<Session> getActiveSessions() {
        return null;
    }

    //获取session
    @Override
    protected Session doReadSession(Serializable sessionId) {

        return getShiroSession(sessionId.toString());
    }

    //创建session
    @Override
    protected Serializable doCreate(Session session) {
        Serializable sessionId = generateSessionId(session);
        assignSessionId(session, sessionId);
        setShiroSession(sessionId.toString(),session);
        return sessionId;
    }


    private Session getShiroSession(String sessionId) {
        final String key = RedisKeys.getShiroSessionKey(sessionId);
        return (Session)redisTemplate.opsForValue().get(key);
    }

    private void setShiroSession(String sessionId, Session session){

        final String key = RedisKeys.getShiroSessionKey(session.getId().toString());

        redisTemplate.opsForValue().set(key, session);
        //60分钟过期
        redisTemplate.expire(key, 60, TimeUnit.MINUTES);
    }



}
