package com.chm.shop.mapper;

import com.chm.shop.manager.menu.dataobject.MenuDO;
import com.chm.shop.manager.menu.query.MenuQuery;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

import java.util.List;


public interface MenuMapper {
    /**
     * 新增
     */
    int insert(MenuDO menuDO);

    /**
     * 更新
     */
    int update(MenuDO menuDO);

    /**
     * 主键查询
     */
    MenuDO getById(Long id);

    /**
     * 根据主键删除
     */
    void delById(Long id);

    /**
     * 列表查询
     */
    PageList<MenuDO> list(MenuQuery menuQuery , PageBounds pageBounds);

}