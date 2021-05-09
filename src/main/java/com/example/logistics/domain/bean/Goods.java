package com.example.logistics.domain.bean;

import lombok.Data;

import java.util.Date;

/**
 * @author hexiaobo
 * @title: Goods
 * @projectName logistics
 * @description: Goods
 * @date 2019/5/10 20:04
 */
@Data
public class Goods {
    private Long id;
    /**
     * 商品编码
     */
    private String goodCode;

    private String goodName;
    /**
     * 商品库存
     */
    private Integer goodStock;

    private Date createTime;
}