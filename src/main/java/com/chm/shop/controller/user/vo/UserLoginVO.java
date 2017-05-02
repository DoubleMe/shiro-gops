package com.chm.shop.controller.user.vo;

/**
 * Created by chen-hongmin on 2017/4/30.
 */
public class UserLoginVO {

    private String userName;

    private String userPwd;

    private Integer type;

    public String getUserName() {

        return userName;
    }

    public void setUserName(String userName) {

        this.userName = userName;
    }

    public String getUserPwd() {

        return userPwd;
    }

    public void setUserPwd(String userPwd) {

        this.userPwd = userPwd;
    }

    public Integer getType() {

        return type;
    }

    public void setType(Integer type) {

        this.type = type;
    }
}
