package com.example.logistics.domain.req.member;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author hexiaobo
 * @title: AddMemberRechargeReq
 * @projectName logistics
 * @description: AddMemberRechargeReq
 * @date 2019/5/10 17:55
 */
@Data
public class AddMemberRechargeReq {
    /**
     * 门店编号
     */
    private String shopNo;
    /**
     * 会员卡号
     */
    private String code;
    /**
     * 充值金额
     */
    private BigDecimal rechargeAmount;
    /**
     * 充值赠送金额
     */
    private BigDecimal giveAmount;
}