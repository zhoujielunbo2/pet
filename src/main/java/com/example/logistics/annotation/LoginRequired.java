package com.example.logistics.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author hexiaobo
 * @title: LoginRequired
 * @projectName csa-biz-service
 * @description: 在需要登录验证的Controller的方法上使用此注解
 * @date 2019/5/9 14:24
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface LoginRequired {
}