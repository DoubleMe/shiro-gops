package com.chm.shop.manager.log.dataobject;

import java.util.Date;


public class LogApiDO {

    private Integer id;

    /**
     * 接口模块
     */
    private String module;

    /**
     * 请求方式
     */
    private String method;

    /**
     * 接口信息
     */
    private String message;

    /**
     * 访问接口
     */
    private String uri;

    /**
     * 用户登录Id
     */
    private String loginId;

    /**
     * 创建时间
     */
    private Date gmtCreated;

    /**
     * 修改时间
     */
    private Date gmtModified;


    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getModule() {
        return this.module;
    }

    public void setModule(String module) {
        this.module = module;
    }

    public String getMethod() {
        return this.method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getUri() {
        return this.uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getLoginId() {
        return this.loginId;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    public Date getGmtCreated() {
        return this.gmtCreated;
    }

    public void setGmtCreated(Date gmtCreated) {
        this.gmtCreated = gmtCreated;
    }

    public Date getGmtModified() {
        return this.gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    @Override
    public String toString() {
        return "LogApiDO{" +
                "module='" + module + '\'' +
                ", method='" + method + '\'' +
                ", message='" + message + '\'' +
                ", uri='" + uri + '\'' +
                ", loginId='" + loginId + '\'' +
                '}';
    }
}