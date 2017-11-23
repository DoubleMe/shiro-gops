package com.chm.shop.web.common.exception;

/**
 * @author chen-hongmin
 * @since 2017/11/23 10:20
 */
public class ParamValidException extends RuntimeException {

    public ParamValidException(String message) {
        super(message);
    }

    public ParamValidException(String message, Throwable cause) {
        super(message, cause);
    }
}
