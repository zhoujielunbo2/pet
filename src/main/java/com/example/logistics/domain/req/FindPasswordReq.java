package com.example.logistics.domain.req;

import lombok.Data;

import java.io.Serializable;

/**
 * @author hexiaobo
 * @title: FindPasswordReq
 * @projectName logistics
 * @description: TODO
 * @date 2019/4/2021:45
 */
@Data
public class FindPasswordReq implements Serializable {
    /**
     * 手机号
     */
    private String phone;
    /**
     * 验证码
     */
    private String verifyCode;
    /**
     * 密码
     */
    private String password;
    /**
     * 确认密码
     */
    private String confirmPassword;
}