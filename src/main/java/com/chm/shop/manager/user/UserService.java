package com.chm.shop.manager.user;

import com.chm.shop.app.common.reponse.PageResponse;
import com.chm.shop.app.common.reponse.Response;
import com.chm.shop.manager.menu.dataobject.MenuDO;
import com.chm.shop.manager.user.dataobject.UserDO;
import com.chm.shop.manager.user.query.UserQuery;

import java.util.List;


/**
 * @author chen-hongmin
 * @since 2017/10/31 13:23
 */
public interface UserService {

    /**
     * 列表查询
     * @return
     */
    PageResponse<UserDO> list(UserQuery userQuery);

    /**
     * 用户注册
     * @param userDO
     * @return
     */
    Response<UserDO> register(UserDO userDO);

    /**
     * 根据loginId 查询用户
     * @param loginId
     * @return
     */
    UserDO getByLoginId(String loginId);

    /**
     * 获取菜单列表
     * @param userId
     * @return
     */
    Response<List<MenuDO>> listMenu(Long userId);
}
