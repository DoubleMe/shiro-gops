package com.chm.shop.mapper;

import com.chm.shop.manager.menu.dataobject.MenuDO;
import com.chm.shop.manager.rolemenu.dataobject.RoleMenuDO;
import com.chm.shop.manager.rolemenu.query.RoleMenuQuery;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

import java.util.List;


public interface RoleMenuMapper {
    /**
     * 新增
     */
    int insert(RoleMenuDO roleMenuDO);

    /**
     * 更新
     */
    int update(RoleMenuDO roleMenuDO);

    /**
     * 主键查询
     */
    List<RoleMenuDO>  getByRoleId(Long roleId);

    /**
     * 根据主键删除
     */
    void delById(Long roleId);

    /**
     * 列表查询
     */
    PageList<RoleMenuDO> list(RoleMenuQuery query, PageBounds pageBounds);

    /**
     * 主键查询
     */
    List<MenuDO> listMenu(Long roleId);
}