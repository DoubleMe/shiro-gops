package com.chm.shop.manager.menu.query;

import com.chm.shop.app.common.query.PageQuery;

/**
 * @author chen-hongmin
 * @since 2017/11/1 17:57
 */
public class MenuQuery extends PageQuery {


    private String name;

    private Integer type;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}
