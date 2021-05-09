package com.example.logistics.service.impl;

import com.example.logistics.common.CommonResult;
import com.example.logistics.domain.req.goods.AddGoodsReq;
import com.example.logistics.mapper.GoodsMapper;
import com.example.logistics.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 * @author hexiaobo
 * @title: GoodsServiceImpl
 * @projectName logistics
 * @description: GoodsServiceImpl
 * @date 2019/5/10 20:05
 */
@Service
public class GoodsServiceImpl implements GoodsService {
    @Autowired
    private GoodsMapper goodsMapper;

//    @Transactional(rollbackFor = Exception.class)
    @Override
    public CommonResult addGoods(AddGoodsReq req) {
        return CommonResult.success();
    }
}