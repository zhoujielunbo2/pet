package com.example.logistics.domain.bean;
import lombok.Data;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author hexiaobo
 * @title: GoodsPrice
 * @projectName logistics
 * @description: GoodsPrice
 * @date 2019/5/10 20:31
 */
@Data
public class GoodsPrice {


    private String goodCode;
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

    private Date createTime;
}