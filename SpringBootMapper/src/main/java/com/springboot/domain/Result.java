package com.springboot.domain;

public class Result<T> {

    private Integer code;
    private String message;
    private T data;

    public Result() {
    }

    public Result(T data) {
        this.data = data;
        this.code = 200;
        this.message = "成功";
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
