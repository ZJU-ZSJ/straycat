package com.ninjaduoduo.common.response;

import com.ninjaduoduo.common.model.ErrorCode;

import java.io.Serializable;

public class Response<T> implements Serializable {

    private static final long serialVersionUID = 1L;
    protected boolean success;
    protected Integer errorCode;
    protected String errorMsg;
    protected T result;

    public Response() {
    }

    private Response(Builder<T> builder) {
        this.success = builder.success;
        this.errorCode = builder.errorCode;
        this.errorMsg = builder.errorMsg;
        this.result = builder.result;
    }

    public static <T> Builder<T> success(T result) {
        return new Builder<>(result).success(true)
                .errorCode(ErrorCode.SUCCESS.getCode())
                .errorMsg(ErrorCode.SUCCESS.getDesc());
    }

    public static <T> Builder<T> fail(T result) {
        return new Builder<>(result).success(false);
    }

    public static <T> Response<T> buildSuccessResponse() {
        return new Builder<T>().success(true).build();
    }

    public static <T> Response<T> buildFailedResponse() {
        return new Builder<T>().success(false).build();
    }

    public static <T> Response<T> buildSuccessResponse(T result) {
        return new Builder<>(result).success(true).build();
    }

    public static <T> Response<T> buildSuccessResponse(T result, ErrorCode errorCode) {
        return new Builder<>(result).success(true).errorCode(errorCode.getCode()).build();
    }

    public static <T> Response<T> buildFailedResponse(T result) {
        return new Builder<>(result).success(false).build();
    }

    public static <T> Response<T> buildFailedResponse(ErrorCode errorCode, T result) {
        return new Builder<>(result).success(false)
                .errorCode(errorCode.getCode())
                .errorMsg(errorCode.getDesc()).build();
    }

    public static <T> Response<T> buildFailedReponse(ErrorCode errorCode) {
        return Response.buildFailedReponse(errorCode, errorCode.getDesc());
    }

    public static <T> Response<T> buildFailedReponse(ErrorCode errorCode, String errorMsg) {
        String msg = errorMsg == null ? errorCode.getDesc() : errorMsg;
        return new Builder<T>().success(false)
                .errorCode(errorCode.getCode())
                .errorMsg(msg)
                .build();
    }

    public static <T,L> Response<T> buildFailedReponse(Response<L> response) {
        String msg = response.getErrorMsg();
        return new Builder<T>().success(false)
                .errorCode(response.getErrorCode())
                .errorMsg(msg)
                .build();
    }

    public static final class Builder<T> {

        private boolean success = false;
        private Integer errorCode;
        private String errorMsg;
        private T result;

        private Builder() {
        }

        private Builder(T result) {
            this.result = result;
        }

        public Response<T> build() {
            return new Response<>(this);
        }

        public Builder<T> success(boolean success) {
            this.success = success;
            this.errorCode = ErrorCode.SUCCESS.getCode();
            return this;
        }

        public Builder<T> errorCode(Integer errorCode) {
            this.errorCode = errorCode;
            return this;
        }

        public Builder<T> errorMsg(String errorMsg) {
            this.errorMsg = errorMsg;
            return this;
        }

        public Builder<T> result(T result) {
            this.result = result;
            return this;
        }
    }

    public boolean isSuccess() {
        return success;
    }

    public Integer getErrorCode() {
        return errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void updateErrorMsg(String msg) {
        this.errorMsg = msg;
    }

    public T getResult() {
        return result;
    }

}
