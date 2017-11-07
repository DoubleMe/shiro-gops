package com.chm.shop.web.controller.user.vo;

/**
 * Created by yuwen on 2017/4/30.
 */
public class UserLoginVO {

    private String userName;

    private String userPwd;

    private Integer rememberMe;

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

    public Integer getRememberMe() {
        return rememberMe;
    }

    public void setRememberMe(Integer rememberMe) {
        this.rememberMe = rememberMe;
    }
}
