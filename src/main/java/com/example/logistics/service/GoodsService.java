package com.example.logistics.service;

import com.example.logistics.common.CommonResult;
import com.example.logistics.domain.req.goods.AddGoodsReq;

/**
 * @author hexiaobo
 * @title: GoodsService
 * @projectName logistics
 * @description: GoodsService
 * @date 2019/5/10 20:05
 */
public interface GoodsService {
    /**
     * 新增商品
      * @param req
     * @return
     */
    CommonResult addGoods(AddGoodsReq req);
}
