package com.example.logistics.domain.req.order;
import lombok.Data;
import java.math.BigDecimal;
/**
 * @author hexiaobo
 * @title: CreateOrderReq
 * @projectName logistics
 * @description: CreateOrderReq
 * @date 2019/5/12 20:38
 */
@Data
public class CreateOrderReq {
    /**
     * 订单商品总数量
     */
    private Integer goodsTotalNum;

    /**
     * 订单支付金额
     */
    private BigDecimal orderPayAmount;
    /**
     * 备注
     */
    private String remark;

}