package com.example.logistics.domain.bean;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author hexiaobo
 * @title: MemberRechargeRecord
 * @projectName logistics
 * @description: MemberRechargeRecord
 * @date 2019/5/10 17:05
 */
@Data
public class MemberRechargeRecord {
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

    private Date createTime;
}