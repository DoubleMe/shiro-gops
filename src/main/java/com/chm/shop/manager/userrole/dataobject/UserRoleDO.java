package com.chm.shop.manager.userrole.dataobject;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author chen-hongmin
 * @since 2017/11/1 16:28
 */

public class UserRoleDO implements Serializable {

    private Long id;

    private Long userId;

    private Long roleId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }
}
