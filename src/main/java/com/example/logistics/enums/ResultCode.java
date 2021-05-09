package com.example.logistics.enums;

/**
 * @author hexiaobo
 * @title: ResultCode
 * @projectName jdk
 * @description: TODO
 * @date 2019/4/1916:45
 */
public enum ResultCode {
    /**
     *
     */
    SUCCESS("200", "成功"),
    PARA_IS_EMPTY("301","参数不能为空"),
    SYSTEM_EXCEPTION("302","服务器忙"),
    PHONE_IS_VALID("303","手机号不合法"),
    PASSPORT_IS_DIFF("304","确认密码不一致"),
    PHONE_IS_EXIST("305","手机号已存在"),
    PHONE_IS_NOT_EXIST("306","手机号不存在"),
    PASSPORT_ERROR("307","密码错误"),
    PHONE_IS_NOT_NULL("308","手机号不能为空"),
    NO_LOGIN("309","未登录"),
    PASSWORD_OIS_NOT_EMPTY("310","密码不能为空"),
    CODE_IS_NOT_EXIST("311","卡号不存在"),
    RECORD_IS_EXIST("312","记录已存在"),
    GOODS_CATEGORY_IS_EXIST("313","商品已挂在分类下"),
    GOODS_IS_NOT_EXIST("314","商品不存在");
    private final String code;
    private final String msg;

    public String getCode() {
        return this.code;
    }

    public String getMsg() {
        return this.msg;
    }

    ResultCode(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

}