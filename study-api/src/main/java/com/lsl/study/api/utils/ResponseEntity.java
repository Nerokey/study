package com.lsl.study.api.utils;

import java.io.Serializable;

public class ResponseEntity<T> implements Serializable {

    public static final int SUCCESS_CODE = 200;
    public static final int FAIL_CODE = 500;

    private Integer code;  //返回代码
    private String msg;  //返回消息
    private boolean success;  //是否成功
    private T data;  //返回数据
    private Long time = System.currentTimeMillis();

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Long getTime() {
        return time;
    }
}
