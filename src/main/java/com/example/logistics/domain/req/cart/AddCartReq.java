package com.example.logistics.domain.req.cart;

import lombok.Data;

/**
 * @author hexiaobo
 * @title: AddCartReq
 * @projectName logistics
 * @description: AddCartReq
 * @date 2019/5/12 16:02
 */
@Data
public class AddCartReq {
    /**
     * 商品编码
     */
    private String goodCode;
    /**
     * 商品总数量
     */
    private Integer num;

}