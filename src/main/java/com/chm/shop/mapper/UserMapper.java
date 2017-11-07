package com.chm.shop.mapper;

import com.chm.shop.manager.user.dataobject.UserDO;
import com.chm.shop.manager.user.query.UserQuery;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

import java.util.List;


public interface UserMapper {
    /**
     * 新增
     */
    int insert(UserDO User);

    /**
     * 更新
     */
    int update(UserDO tUser);

    /**
     * 主键查询
     */
    UserDO getById(Long id);

    /**
     * 主键查询
     */
    UserDO getByLoginId(String loginId);

    /**
     * 根据主键删除
     */
    void delById(Long id);

    /**
     * 列表查询
     */
    PageList<UserDO> list(UserQuery userQuery, PageBounds pageBounds);

}