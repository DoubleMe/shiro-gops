package com.chm.shop.manager.userrole;

import com.chm.shop.app.common.reponse.Response;
import com.chm.shop.manager.userrole.dataobject.UserRoleDO;

/**
 * @author chen-hongmin
 * @since 2017/11/6 14:40
 */
public interface UserRoleService {

    /**
     * 新增
     */
    Response<UserRoleDO> insert(UserRoleDO userRole);

    /**
     * 更新
     */
    Response<UserRoleDO> update(UserRoleDO userRole);

    /**
     * 主键查询
     */
    Response<UserRoleDO> getByUserId(Long userId);
}
