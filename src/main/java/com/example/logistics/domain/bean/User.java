package com.example.logistics.domain.bean;

import lombok.Data;

import java.util.Date;

/**
 * @author hexiaobo
 * @projectName jdk
 * @description: TODO
 * @date 2019/4/1919:09
 */
@Data
public class User {
    private String phone;
    private String nickName;
    private String password;
    private String headPic;
    private Date createTime;
    private Integer type;
    /**
     * 领导id
     */
    private Long leaderId;
}