package com.example.logistics.domain.req;

import lombok.Data;

import java.io.Serializable;

/**
 * @author hexiaobo
 * @title: RegisterReq
 * @projectName jdk
 * @description: TODO
 * @date 2019/4/1917:04
 */
@Data
public class RegisterReq implements Serializable {
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
    /**
     * 昵称
     */
    private String nickName;
    /**
     * 1:员工 2:店长  3:老板
      */
    private Integer type;
    /**
     * 领导id
     */
    private Long leaderId;
}