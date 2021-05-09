package com.example.logistics.domain.bean;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author hexiaobo
 * @title: Member
 * @projectName logistics
 * @description: Member
 * @date 2019/5/7 17:59
 */
@Data
public class Member {

    private Long id;


    private String shopNo;

    /**
     * 充值金额
     */
    private BigDecimal rechargeAmount;
    /**
     * 充值赠送金额
     */
    private BigDecimal giveAmount;
    /**
     * 消费密码
     */
    private String shoppingPwd;
    /**
     *
     */
    private String memberAddress;


    private String shopName;
    /**
     * 会员卡号 有可能是字母
     */
    private String code;
    /**
     * 会员积分
     */
    private Integer points;
    /**
     * 手机号码
     */
    private String phone;

    private String name;

    private String birthday;
    /**
     * 是否可用，0可用，1暂停，2失效
     */
    private Integer state;
    /**
     * 是否有设置会员密码 1:有 2没有
     */
    private Integer isPwd;
    /**
     * 会员折扣
     *
     */
    private BigDecimal discount;

    /**
     * 会员等级
     */
    private Integer level;
    /**
     * 备注
     */
    private String remark;
    /**
     * 余额
      */
    private BigDecimal balance;
    /**
     * 生成日期
     */
    private Date createDate;

    private String password;
    /**
     * 是否可以赊账 1：是 2：否
     */
    private Integer onCredit;
}