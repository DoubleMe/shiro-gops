package com.chm.shop.manager.online;

import com.chm.shop.app.UserToken;
import com.chm.shop.app.common.reponse.Response;

import java.util.List;

/**
 * @author chen-hongmin
 * @since 2017/11/7 16:37
 */
public interface OnlineService {

    Response<List<UserToken>> onlineUser();
}
