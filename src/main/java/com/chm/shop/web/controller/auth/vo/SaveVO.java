package com.chm.shop.web.controller.auth.vo;

/**
 * @author chen-hongmin
 * @since 2017/11/6 11:30
 */
public class SaveVO {

    private Long roleId;

    private String menuId;

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getMenuId() {
        return menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId;
    }
}
