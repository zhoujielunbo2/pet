package com.example.logistics.exception;

import com.example.logistics.common.CommonResponse;
import com.example.logistics.common.CsaBizResponseCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author hexiaobo
 * @title: BizExceptionHandler
 * @projectName logistics
 * @description: BizExceptionHandler
 * @date 2019/5/7 17:59
 */
@ControllerAdvice
public class BizExceptionHandler {

    private final static Logger LOGGER = LoggerFactory.getLogger(BizExceptionHandler.class);
    @org.springframework.web.bind.annotation.ExceptionHandler(RuntimeException.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public CommonResponse<?> handleUnexpectedServerError(RuntimeException ex) {
        LOGGER.error("[System]未捕获的异常", ex);
        return CommonResponse.fail(CsaBizResponseCode.SYSTEM_ERROR.code,ex.getMessage());
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(BusinessException.class)
    @ResponseBody
    public CommonResponse<?> handleBusinessException(BusinessException e) {
        LOGGER.warn("handleBusinessException exception", e);
        return ExceptionHandler.handle(e);
    }
}
