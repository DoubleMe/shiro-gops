package com.chm.shop.manager.menu;

import com.chm.shop.app.common.reponse.PageResponse;
import com.chm.shop.app.common.reponse.Response;
import com.chm.shop.manager.menu.dataobject.MenuDO;
import com.chm.shop.manager.menu.query.MenuQuery;

import java.util.List;

/**
 * @author chen-hongmin
 * @since 2017/11/1 17:57
 */
public interface MenuService {

    /**
     * 列表查询
     * @return
     */
    PageResponse<List<MenuDO>> list(MenuQuery menuQuery);

    /**
     * 添加菜单
     * @param menuDO
     * @return
     */
    Response<MenuDO> save(MenuDO menuDO);

    /**
     * 添加菜单
     * @param id
     * @return
     */
    Response<Boolean> delete(Long id);

    /**
     * 详情
     * @param id
     * @return
     */
    Response<MenuDO> detail(Long id);
}
