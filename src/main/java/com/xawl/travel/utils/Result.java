package com.xawl.travel.utils;


/**
 * Created Administrator on 2017/11/17.
 */
public class Result {
    private Integer status;
    private String msg;
    private Object data;

    public Result() {

    }

    public Result(Integer status, String msg, Object data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    public static Result success() {
        return new Result(200, "操作成功", null);
    }

    public static Result success(String msg) {
        return new Result(200, msg, null);
    }

    public static Result success(Object data) {
        return new Result(200, "操作成功", data);
    }

    public static Result success(String msg, Object data) {
        return new Result(200, msg, data);
    }

    public static Result fail(String msg) {
        return new Result(400, msg, null);
    }

    public static Result fail(Integer status, String msg) {
        return new Result(status, msg, null);
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Result [status=" + status + ", msg=" + msg + ", data=" + data + "]";
    }

}






