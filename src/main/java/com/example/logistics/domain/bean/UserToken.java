package com.example.logistics.domain.bean;

import lombok.Data;

/**
 * @author hexiaobo
 * @title: UserToken
 * @projectName jdk
 * @description: TODO
 * @date 2019/4/2016:28
 */
@Data
public class UserToken {
    private Integer id;
    private String token;
    private String phone;
    private Integer type;
}