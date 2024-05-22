package com.health.care.models;

public class ApiResponse<T> {
    private int code;
    private T data;
    private ApiError error;

    public ApiResponse() {
    }

    public ApiResponse(int code, T data, ApiError error) {
        this.code = code;
        this.data = data;
        this.error = error;
    }

    public ApiResponse(int code, T data) {
        this.code = code;
        this.data = data;
    }

    public ApiResponse(int code, ApiError error) {
        this.code = code;
        this.error = error;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public ApiError getError() {
        return error;
    }

    public void setError(ApiError error) {
        this.error = error;
    }
}
