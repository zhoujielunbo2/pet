package com.example.logistics.domain.bean;

import lombok.Data;

/**
 * @author hexiaobo
 * @title: Shop
 * @projectName logistics
 * @description: 店铺
 * @date 2019/5/1 14:11
 */
@Data
public class Shop {
    /**
     * 门店编号
     */
    private String shopNo;
    /**
     * 门店名称
     */
    private String shopName;
    /**
     *店主
     */
    private String shopOwner;
    /**
     *门店地址
     */
    private String shopAddress;
    /**
     * 门店电话
     */
    private String shopTel;
    /**
     * 1:营业中 2：休息中
     */
    private Integer shopStatus;
    /**
     * 省
     */
    private String province;
    /**
     * 省id
     */
    private  Long provinceId;
    /**
     * 城市
     */
    private String city;
    /**
     * 城市id
     */
    private Long cityId;
    /**
     * 店铺所在县市区
     */
    private String area;
    /**
     * 县市区id
     */
    private Long areaId;
    /**
     * 是否开始会员模块，默认开始；开启状态时，积分同时开启
     */
    private Integer isCloseVIP;
    /**
     * 用户手机号
     */
    private String phone;
}