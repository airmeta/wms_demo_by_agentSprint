package com.ruoyi.common.core.exception;

import java.io.Serializable;

/**
 * Generic business exception.
 */
public class ServiceException extends RuntimeException implements Serializable {

    private static final long serialVersionUID = 1L;

    private int code;
    private String message;
    private String detailMessage;

    public ServiceException(String message) {
        this.code = 500;
        this.message = message;
    }

    public ServiceException(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public ServiceException(String message, Throwable cause) {
        super(message, cause);
        this.code = 500;
        this.message = message;
    }

    public ServiceException(int code, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public int getCode() { return code; }
    public void setCode(int code) { this.code = code; }
    public void setMessage(String message) { this.message = message; }
    public String getDetailMessage() { return detailMessage; }
    public void setDetailMessage(String detailMessage) { this.detailMessage = detailMessage; }
}
