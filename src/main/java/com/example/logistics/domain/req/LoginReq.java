package com.example.logistics.domain.req;

import lombok.Data;

import java.io.Serializable;

/**
 * @author hexiaobo
 * @title: LoginReq
 * @projectName jdk
 * @description: TODO
 * @date 2019/4/1920:06
 */
@Data
public class LoginReq implements Serializable {

    private String phone;

    private String password;
    /**
     * 1:员工 2:店长  3:老板
     */
    private Integer type;
}