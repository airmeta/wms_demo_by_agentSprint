package com.ruoyi.common.core.domain;

import com.ruoyi.common.core.constant.Constants;
import com.ruoyi.common.core.constant.HttpStatus;
import io.swagger.v3.oas.annotations.media.Schema;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Unified response wrapper.
 */
@Schema(description = "Unified REST response")
public class R<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    @Schema(description = "Status code")
    private int code;

    @Schema(description = "Message")
    private String msg;

    @Schema(description = "Payload")
    private T data;

    public R() {}

    public R(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public R(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static <T> R<T> ok() {
        return restResult(null, Constants.SUCCESS, "operation success");
    }

    public static <T> R<T> ok(T data) {
        return restResult(data, Constants.SUCCESS, "operation success");
    }

    public static <T> R<T> ok(T data, String msg) {
        return restResult(data, Constants.SUCCESS, msg);
    }

    public static <T> R<T> fail() {
        return restResult(null, Constants.FAIL, "operation failed");
    }

    public static <T> R<T> fail(String msg) {
        return restResult(null, Constants.FAIL, msg);
    }

    public static <T> R<T> fail(int code, String msg) {
        return restResult(null, code, msg);
    }

    public static <T> R<T> fail(T data, String msg) {
        return restResult(data, Constants.FAIL, msg);
    }

    public static <T> R<T> restResult(T data, int code, String msg) {
        R<T> r = new R<>();
        r.setCode(code);
        r.setMsg(msg);
        r.setData(data);
        return r;
    }

    public boolean isSuccess() {
        return this.code == Constants.SUCCESS;
    }

    public int getCode() { return code; }
    public void setCode(int code) { this.code = code; }
    public String getMsg() { return msg; }
    public void setMsg(String msg) { this.msg = msg; }
    public T getData() { return data; }
    public void setData(T data) { this.data = data; }

    public Map<String, Object> toMap() {
        Map<String, Object> map = new HashMap<>(4);
        map.put("code", code);
        map.put("msg", msg);
        map.put("data", data);
        return map;
    }
}
