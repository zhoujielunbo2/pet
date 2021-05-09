package com.example.logistics.domain.bean;

import lombok.Data;

import java.util.Date;

/**
 * @author hexiaobo
 * @title: GoodsCategoryRelation
 * @projectName logistics
 * @description: GoodsCategoryRelation
 * @date 2019/5/10 20:31
 */
@Data
public class GoodsCategoryRelation {
    private Long id;
    private Long categoryId;
    private String goodCode;
    private Date createTime;
}