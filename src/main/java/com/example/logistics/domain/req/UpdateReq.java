package com.example.logistics.domain.req;

import lombok.Data;

import java.io.Serializable;

/**
 * @author hexiaobo
 * @title: UpdateReq
 * @projectName jdk
 * @description: TODO
 * @date 2019/4/2014:09
 */
@Data
public class UpdateReq implements Serializable {
    private String token;
    private String phone;
    private String nickName;
    private String password;
    private Integer type;

}