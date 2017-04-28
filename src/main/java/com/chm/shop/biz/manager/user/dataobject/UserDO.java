package com.chm.shop.biz.manager.user.dataobject;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by chen-hongmin on 2017/4/27.
 */
@Entity
@Table(name = "t_user_info",schema = "用户信息表")
public class UserDO {

    /**
     * 用户ID
     */
    @Id
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
     * 用户密码
     */
    private String userPwd;

    /**
     * 用户地址
     */
    private String addr;

    /**
     * 用户身份证
     */
    private String userCard;

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

    public String getUserPwd() {

        return userPwd;
    }

    public void setUserPwd(String userPwd) {

        this.userPwd = userPwd;
    }

    public String getAddr() {

        return addr;
    }

    public void setAddr(String addr) {

        this.addr = addr;
    }

    public String getUserCard() {

        return userCard;
    }

    public void setUserCard(String userCard) {

        this.userCard = userCard;
    }
}
