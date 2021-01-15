package org.fancy.seckill.common.util;

import org.fancy.seckill.common.resp.Response;

import static org.fancy.seckill.common.resp.Response.MSREQUEST_FAIL_CODE;
import static org.fancy.seckill.common.resp.Response.MSREQUEST_SUCCESS_CODE;

public class RetResponse {

    private static final String SUCCESS = "success";

    public static <T> Response<T> makeOKRsp() {
        Response<T> response = new Response<>();
        response.setCode(MSREQUEST_SUCCESS_CODE);
        response.setMsg(SUCCESS);
        return response;
    }

    public static <T> Response<T> makeOKRsp(T data) {
        Response<T> response = new Response<>();
        response.setCode(MSREQUEST_SUCCESS_CODE);
        response.setMsg(SUCCESS);
        response.setData(data);
        return response;
    }

    public static <T> Response<T> makeErrRsp(String message) {
        Response<T> response = new Response<>();
        response.setCode(MSREQUEST_FAIL_CODE);
        response.setMsg(message);
        return response;
    }

    public static <T> Response<T> makeErrRsp(String message, T data) {
        Response<T> response = new Response<>();
        response.setCode(MSREQUEST_FAIL_CODE);
        response.setMsg(message);
        response.setData(data);
        return response;
    }

    public static boolean isSuccess(Response<?> response) {
        return response != null && response.getCode() == MSREQUEST_SUCCESS_CODE;
    }
}
