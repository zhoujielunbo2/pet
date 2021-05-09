package com.example.logistics.domain.resp;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hexiaobo
 * @title: LoginResp
 * @projectName jdk
 * @description: TODO
 * @date 2019/4/2016:19
 */
@Data
public class LoginResp {
    private String token;
    private String headPic;
    private List<ShopResp> shopRespList=new ArrayList<>();

}