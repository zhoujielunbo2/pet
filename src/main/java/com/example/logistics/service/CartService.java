package com.example.logistics.service;

import com.example.logistics.common.CommonResult;
import com.example.logistics.domain.req.cart.AddCartListReq;


/**
 * @author hexiaobo
 * @title: CartService
 * @projectName logistics
 * @description: CartService
 * @date 2019/5/12 16:05
 */
public interface CartService {
    /**
     * 计算购物车商品总金额
     * @param req
     * @return
     */
    CommonResult calculateTotalAmount(AddCartListReq req);
}
