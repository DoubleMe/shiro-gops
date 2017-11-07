package com.chm.shop.web.controller.auth.vo;

/**
 * @author chen-hongmin
 * @since 2017/11/6 11:05
 */
public class RoleMenuVO {

    private boolean LAY_CHECKED;

    private Long id;

    private String name;

    public boolean getLAY_CHECKED() {
        return LAY_CHECKED;
    }

    public void setLAY_CHECKED(boolean LAY_CHECKED) {
        this.LAY_CHECKED = LAY_CHECKED;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
