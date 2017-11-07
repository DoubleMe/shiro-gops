package com.chm.shop.web.common;

/**
 * Created by yuwen on 2017/5/25.
 */
public class BaseJsonObject {


    private boolean error;

    private String message;

    private Object data;

    public void errorRes(String message) {

        this.error = true;
        this.message = message;
    }

    public void successRes(String message, Object data) {

        this.error = false;
        this.message = message;
        this.data = data;
    }

    public boolean isError() {

        return error;
    }

    public void setError(boolean error) {

        this.error = error;
    }

    public String getMessage() {

        return message;
    }

    public void setMessage(String message) {

        this.message = message;
    }

    public Object getData() {

        return data;
    }

    public void setData(Object data) {

        this.data = data;
    }
}
