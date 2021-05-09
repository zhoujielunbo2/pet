package com.example.logistics.domain.req.cart;

import lombok.Data;
import java.util.List;

/**
 * @author hexiaobo
 * @title: AddCartListReq
 * @projectName logistics
 * @description: AddCartListReq
 * @date 2019/5/12 16:04
 */
@Data
public class AddCartListReq {
    /**
     * 会员卡号
     */
    private String code;
    /**
     * 店铺编码
     */
    private String shopNo;
    /**
     * 购物车商品列表
      */
    private List<AddCartReq> goodsList;
}