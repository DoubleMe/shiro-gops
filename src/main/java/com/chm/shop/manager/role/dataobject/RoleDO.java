package com.chm.shop.manager.role.dataobject;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author chen-hongmin
 * @since 2017/11/1 16:03
 */
@Entity
@Table(name = "t_role",schema = "角色信息表")
public class RoleDO implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String salt;

    private String loginId;

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

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getLoginId() {
        return loginId;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }
}
