package com.example.logistics.domain.bean;
import lombok.Data;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author hexiaobo
 * @title: OrderInfo
 * @projectName logistics
 * @description: OrderInfo
 * @date 2019/5/12 20:23
 */
@Data
public class OrderInfo {
    /**
     * 订单号
     */
    private String orderNo;
    /**
     * 订单状态 1:已付款 2已退款
     */
    private Integer orderStatus;
    /**
     * 订单商品总数量
     */
    private Integer goodsTotalNum;

    /**
     * 订单支付金额
     */
    private BigDecimal orderPayAmount;

    private String remark;

    private Date createTime;

}