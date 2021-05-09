package com.example.logistics.domain.req.member;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author hexiaobo
 * @title: AddMemberReq
 * @projectName logistics
 * @description: AddMemberReq
 * @date 2019/5/9 19:04
 */
@Data
public class AddMemberReq {

    private String code;

    /**
     * 消费密码
     */
    private String shoppingPwd;
    /**
     *会员地址
     */
    private String memberAddress;
    private String shopNo;

    private String shopName;
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
     * 密码
     */
    private String password;
    /**
     * 是否可以赊账
     */
    private boolean onCredit;
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
    private String createDate;
}