package com.example.logistics.domain.resp;

import lombok.Data;

/**
 * @author hexiaobo
 * @title: ShopResp
 * @projectName logistics
 * @description: ShopResp
 * @date 2019/5/7 19:45
 */
@Data
public class ShopResp {

    private Long shopId;
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
    private boolean isCloseVIP;
    /**
     * 用户手机号
     */
    private String phone;
}