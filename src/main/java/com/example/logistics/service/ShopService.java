package com.example.logistics.service;

import com.example.logistics.common.CommonResult;
import com.example.logistics.domain.req.shop.AddShopReq;

/**
 * @author hexiaobo
 * @title: ShopService
 * @projectName logistics
 * @description: ShopService
 * @date 2019/5/1 14:44
 */
public interface ShopService {
    /**
     * 新增店铺
     * @param addShopReq
     * @return
     */
    CommonResult addShop(AddShopReq addShopReq);
}
