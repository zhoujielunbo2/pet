package com.example.logistics.domain.req.goodscatrela;

import lombok.Data;

/**
 * @author hexiaobo
 * @title: GoodsCategoryRelationReq
 * @projectName logistics
 * @description: GoodsCategoryRelationReq
 * @date 2019/5/11 15:00
 */
@Data
public class GoodsCategoryRelationReq {
    private String goodCode;
    private Long categoryId;
}