package com.chm.shop.manager.user.dataobject;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by yuwen on 2017/4/27.
 */
public class UserDO implements Serializable{

    /**
     * 用户ID
     */
    private Long id;

    /**
     * 用户登录名
     */
    @NotBlank(message = "用户登录名不能为空")
    private String loginId;

    /**
     * 用户名
     */
    @NotBlank(message = "用户名不能为空")
    private String userName;

    /**
     * 用户密码
     */
    @NotBlank(message = "用户密码不能为空")
    private String password;

    /**
     * 盐
     */
    private String salt;

    /**
     * 创建日期
     */
    private Date gmtCreated;

    /**
     * 修改日期
     */
    private Date gmtModified;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public Date getGmtCreated() {
        return gmtCreated;
    }

    public void setGmtCreated(Date gmtCreated) {
        this.gmtCreated = gmtCreated;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }
}
