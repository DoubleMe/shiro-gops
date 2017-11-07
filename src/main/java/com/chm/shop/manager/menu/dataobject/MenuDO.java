package com.chm.shop.manager.menu.dataobject;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @author chen-hongmin
 * @since 2017/11/1 16:17
 */
public class MenuDO implements Serializable {

    private Long id;

    @NotBlank(message = "链接不能为空")
    private String url;
    @NotBlank(message = "菜单名称不能为空")
    private String name;

    @Column(name = "parent_id")
    private Long parentId;

    private String icon;
    @NotNull(message = "菜单类型不能为空")
    private Integer type;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}
