package com.example.logistics.domain.resp;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @author hexiaobo
 * @title: CartCalculateResp
 * @projectName logistics
 * @description: CartCalculateResp
 * @date 2019/5/12 17:05
 */
@Data
@Builder
public class CartCalculateResp {
    /**
     * 支付金额
     */
    private BigDecimal payAmount;
    /**
     * 优惠金额
     */
    private BigDecimal discountAmount;
    /**
     * 总金额
     */
    private BigDecimal totalAmount;
}