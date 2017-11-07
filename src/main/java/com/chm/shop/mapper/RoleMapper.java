package com.chm.shop.mapper;

import com.chm.shop.manager.role.dataobject.RoleDO;
import com.chm.shop.manager.role.query.RoleQuery;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

import java.util.List;


public interface RoleMapper {
    /**
     * 新增
     */
    int insert(RoleDO tRole);

    /**
     * 更新
     */
    int update(RoleDO tRole);

    /**
     * 主键查询
     */
    RoleDO getById(Long id);

    /**
     * 根据主键删除
     */
    void delById(Long id);

    /**
     * 列表查询
     */
    PageList<RoleDO> list(RoleQuery query , PageBounds pageBounds);

}