package com.example.logistics.common;

public enum CsaBizResponseCode {
    /**
     *
     */
    NO_LOGIN("527", "未登录", "未登录"),

    SYSTEM_ERROR("6010", "系统服务异常", "系统忙碌中");
    public String code;

    public String errorMessage;

    public String displayMessage;

    CsaBizResponseCode(String code, String displayMessage, String errorMessage) {
        this.code = code;
        this.displayMessage = displayMessage;
        this.errorMessage = errorMessage ;
    }
    public String getCode() {
        return this.code;
    }

    public String getDisplayMessage() {
        return displayMessage;
    }

    public void setDisplayMessage(String displayMessage) {
        this.displayMessage = displayMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
