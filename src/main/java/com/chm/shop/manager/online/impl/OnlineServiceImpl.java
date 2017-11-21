package com.chm.shop.manager.online.impl;

import com.chm.shop.app.UserToken;
import com.chm.shop.app.cache.BaseCache;
import com.chm.shop.app.cache.RedisKeys;
import com.chm.shop.app.common.reponse.Response;
import com.chm.shop.app.constants.MessageConstats;
import com.chm.shop.app.util.ResponseUtils;
import com.chm.shop.manager.online.OnlineService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author chen-hongmin
 * @since 2017/11/7 16:40
 */
@Service
public class OnlineServiceImpl implements OnlineService{

    @Resource
    private BaseCache baseCache;

    @Override
    public Response<List<UserToken>> onlineUser() {
//        Object value = commonCacheManager.getValue(RedisKeys.getOnlineUserKey());

//

        return null;
    }
}
