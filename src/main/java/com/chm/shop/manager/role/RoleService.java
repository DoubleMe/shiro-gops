package com.chm.shop.manager.role;

import com.chm.shop.app.common.reponse.PageResponse;
import com.chm.shop.app.common.reponse.Response;
import com.chm.shop.manager.role.dataobject.RoleDO;
import com.chm.shop.manager.role.query.RoleQuery;

import java.util.List;

/**
 * @author chen-hongmin
 * @since 2017/11/3 16:22
 */
public interface RoleService {

    /**
     * 新增
     */
    Response<RoleDO> insert(RoleDO role);

    /**
     * 更新
     */
    Response<RoleDO> update(RoleDO role);

    /**
     * 主键查询
     */
    Response<RoleDO> getById(Long id);

    /**
     * 根据主键删除
     */
    Response<Boolean> delById(Long id);

    /**
     * 列表查询
     */
    PageResponse<List<RoleDO>> list(RoleQuery query);
}
