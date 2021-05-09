package com.example.logistics.domain.req.shop;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * @author hexiaobo
 * @title: AddShopReq
 * @projectName logistics
 * @description: AddShopReq
 * @date 2019/5/1 17:41
 */
@Data
public class AddShopReq implements Serializable {
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
    private  Long provinceId;

    private String city;
    private Long cityId;
    /**
     * 店铺所在县市区
     */
    private String area;

    private Long areaId;
    /**
     * 是否开始会员模块，默认开始；开启状态时，积分同时开启
     */
    private boolean isCloseVIP;
    /**
     * 用户id
     */
    @NotBlank
    private String phone;
}