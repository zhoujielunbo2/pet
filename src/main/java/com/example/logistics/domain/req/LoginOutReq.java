package com.example.logistics.domain.req;

import lombok.Data;

/**
 * @author hexiaobo
 * @title: LoginOutReq
 * @projectName jdk
 * @description: TODO
 * @date 2019/4/2016:42
 */
@Data
public class LoginOutReq {
    private String token;
    private Integer type;
}