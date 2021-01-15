package org.fancy.seckill.common.resp;

import java.io.Serializable;

public final class Response<T> implements Serializable {

    public static final int MSREQUEST_SUCCESS_CODE = 0;
    public static final String MSREQUEST_SUCCESS_DESC = "查询信息成功";
    public static final int MSREQUEST_FAIL_CODE = 500;
    public static final String MSREQUEST_FAIL_DESC = "查询信息失败";

    private Integer code;
    private String msg;
    private T data;

    public Response() {
    }

    public Response(Integer code, String msg) {
        this.data = null;
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return this.code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return this.msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return this.data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
