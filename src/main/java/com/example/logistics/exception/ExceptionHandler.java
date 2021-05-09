package com.example.logistics.exception;

import com.example.logistics.common.CommonResponse;
import com.example.logistics.common.CsaBizResponseCode;
/**
 * @author hexiaobo
 * @title: ExceptionHandler
 * @projectName logistics
 * @description: ExceptionHandler
 * @date 2019/5/7 17:59
 */
public class ExceptionHandler {

    /**
     * 处理系统业务异常
     * @param exception
     * @param <T>
     * @return
     */
    public static <T extends BizException> CommonResponse handle(T exception) {
        CsaBizResponseCode errorCode = exception.getErrorCode();
        return CommonResponse.fail(errorCode.code, exception.getFriendMessage());
    }
}
