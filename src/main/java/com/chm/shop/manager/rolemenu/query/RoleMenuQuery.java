package com.chm.shop.manager.rolemenu.query;

import com.chm.shop.app.common.query.PageQuery;

/**
 * @author chen-hongmin
 * @since 2017/11/6 10:49
 */
public class RoleMenuQuery extends PageQuery{

    private Long roleId;

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }
}
