package com.chm.shop.app.common.enums;

/**
 * @author chen-hongmin
 * @since 2017/11/7 17:52
 */
public enum  SystemModuleEnum {
    USER("user"),MENU("menu"),ROLE("role"),AUTH("auth");

    private String module;

    SystemModuleEnum(String module) {
        this.module = module;
    }

    public String getModule() {
        return module;
    }
}
