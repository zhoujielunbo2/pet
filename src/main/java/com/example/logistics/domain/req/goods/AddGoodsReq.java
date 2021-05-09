package com.example.logistics.domain.req.goods;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author hexiaobo
 * @title: AddGoodsReq
 * @projectName logistics
 * @description: AddGoodsReq
 * @date 2019/5/12 9:47
 */
@Data
public class AddGoodsReq {
    /**
     * 商品编码
     */
    private String goodCode;
    /**
     * 商品名称
     */
    private String goodName;
    /**
     * 商品库存
     */
    private Integer goodStock;
    /**
     * 会员价
     */
    private BigDecimal memberPrice;
    /**
     * 销售价
     */
    private BigDecimal salePrice;
    /**
     * 成本价
     */
    private BigDecimal basePrice;
    /**
     * 所属分类id
      */
    private Long categoryId;

}