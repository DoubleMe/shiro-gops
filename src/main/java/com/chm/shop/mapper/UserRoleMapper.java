package com.chm.shop.mapper;

import com.chm.shop.manager.userrole.dataobject.UserRoleDO;

import java.util.List;


public interface UserRoleMapper {
    /**
     * 新增
     */
    int insert(UserRoleDO userRole);

    /**
     * 更新
     */
    int update(UserRoleDO userRole);

    /**
     * 主键查询
     */
    UserRoleDO getByUserId(Long userId);

    /**
     * 根据主键删除
     */
    void delById(Integer id);

    /**
     * 列表查询
     */
    List<UserRoleDO> list();

}