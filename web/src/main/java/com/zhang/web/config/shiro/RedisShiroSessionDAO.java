/**
 * Copyright 2018 人人开源 http://www.renren.io
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package com.zhang.web.config.shiro;
import com.zhang.web.utils.RedisKeys;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.SimpleSession;
import org.apache.shiro.session.mgt.eis.EnterpriseCacheSessionDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.concurrent.TimeUnit;

/**
 * shiro session dao
 */
@Component
public class RedisShiroSessionDAO extends EnterpriseCacheSessionDAO {
    protected Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 创建session
     * @param session
     * @return
     */
    @Override
    protected Serializable doCreate(Session session) {
        Serializable sessionId = this.generateSessionId(session);
        SimpleSession session1 = (SimpleSession) session;
        session1.setId(sessionId);
        final String key = RedisKeys.getShiroSessionKey(sessionId.toString());
        logger.info("session key:"+key);
        setShiroSession(key, session);

        return sessionId;
    }

    /**
     *
     * @param sessionId
     * @return
     */
    @Override
    protected Session doReadSession(Serializable sessionId) {
        Session session = super.doReadSession(sessionId);
        if(session == null){
            final String key = RedisKeys.getShiroSessionKey(sessionId.toString());
            session = getShiroSession(key);
        }
        return session;
    }

    /**
     * 更新session
     * @param session
     */
    @Override
    protected void doUpdate(Session session) {
        super.doUpdate(session);
        final String key = RedisKeys.getShiroSessionKey(session.getId().toString());
        setShiroSession(key, session);
    }

    /**
     * 删除session
     * @param session
     */
    @Override
    protected void doDelete(Session session) {
        super.doDelete(session);
        final String key = RedisKeys.getShiroSessionKey(session.getId().toString());
        redisTemplate.delete(key);
    }

    private Session getShiroSession(String key) {
        Session session= null;
        try {
            session = (Session)redisTemplate.opsForValue().get(key);
        } catch (Exception e) {
            e.printStackTrace();
            redisTemplate.delete(key);
        }
        return session;
    }

    private void setShiroSession(String key, Session session){
        redisTemplate.opsForValue().set(key, session);
        //60分钟过期
        redisTemplate.expire(key, 60*24, TimeUnit.MINUTES);
    }

}
