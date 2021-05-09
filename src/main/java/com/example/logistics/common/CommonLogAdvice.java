package com.example.logistics.common;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import java.util.Arrays;

/**
 * 通用日志输出
 *
 * @author hexiaobo
 * @create 2019-02-16 20:22
 **/

@Component
@Aspect
@Slf4j
public class CommonLogAdvice {

    @Around(value = "execution(public * *.example.logistics.controller..*.*(..))")
    public Object printCommonLog(ProceedingJoinPoint point) throws Throwable {
        Signature signature = point.getSignature();
        String targetName = point.getTarget().getClass().getName();
        String name = signature.getName();
        Object result;
        Object[] args = point.getArgs();
        try {
            //目标方法之前要执行的操作,相当于@before
            log.info("[around log]  {}.{} begin param={}", targetName, name, Arrays.toString(args));
            //调用目标方法
            result = point.proceed(args);
            //目标方法正常执行之后的操作，相当于@AfterReturning
            log.info("[around log]  {}.{} end result ={}", targetName, name, JSON.toJSONString(result));
        } catch (Throwable e) {
            //目标方法抛出异常信息之后的操作，相当于@AfterThrowing
            log.warn("[around log]  {}.{} error error ={}", targetName, name, e.getMessage());
            throw e;
        }
        return result;
    }
}
