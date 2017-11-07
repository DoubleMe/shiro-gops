package com.chm.shop.manager.rolemenu.dataobject;

import javax.persistence.*;

/**
 * @author chen-hongmin
 * @since 2017/11/1 17:50
 */

@Entity
@Table(name = "t_role_menu",schema = "角色权限表")
public class RoleMenuDO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long roleId;

    private Long menuId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Long getMenuId() {
        return menuId;
    }

    public void setMenuId(Long menuId) {
        this.menuId = menuId;
    }
}
