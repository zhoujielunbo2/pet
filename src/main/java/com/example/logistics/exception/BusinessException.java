package com.example.logistics.exception;


import com.example.logistics.common.CsaBizResponseCode;

/**
 * @author hexiaobo
 * @title: BusinessException
 * @projectName csa-biz-service
 * @description: BusinessException
 * @date 2019/5/9 17:42
 */
public class BusinessException extends BizException {
    private CsaBizResponseCode businessExcp;

    public BusinessException(CsaBizResponseCode errorCode) {
        super(errorCode.errorMessage);
        this.businessExcp = errorCode;
    }
    @Override
    public CsaBizResponseCode getErrorCode() {
        return businessExcp;
    }

    @Override
    public String getFriendMessage() {
        return businessExcp.errorMessage;
    }
}