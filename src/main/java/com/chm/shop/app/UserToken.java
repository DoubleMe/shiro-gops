package com.chm.shop.app;

import java.io.Serializable;
import java.util.Date;

/**
 * @author chen-hongmin
 * @since 2017/11/7 14:00
 */
public class UserToken implements Serializable{

    /**
     * 用户ID
     */
    private Long userId;

    /**
     * 用户登录名
     */
    private String loginId;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 角色
     */
    private String role;

    /**
     * 用户登录时间
     */
    private Date loginTime;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getLoginId() {
        return loginId;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Date getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }
}


