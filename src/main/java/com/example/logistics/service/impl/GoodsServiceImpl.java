package com.example.logistics.service.impl;

import com.example.logistics.common.CommonResult;
import com.example.logistics.domain.bean.Goods;
import com.example.logistics.domain.bean.GoodsCategoryRelation;
import com.example.logistics.domain.bean.GoodsPrice;
import com.example.logistics.domain.req.goods.AddGoodsReq;
import com.example.logistics.enums.ResultCode;
import com.example.logistics.mapper.GoodsCategoryRelationMapper;
import com.example.logistics.mapper.GoodsMapper;
import com.example.logistics.mapper.GoodsPriceMapper;
import com.example.logistics.service.GoodsService;
import com.example.logistics.util.CommonUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

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
    @Autowired
    private GoodsPriceMapper goodsPriceMapper;
    @Autowired
    private GoodsCategoryRelationMapper relationMapper;

//    @Transactional(rollbackFor = Exception.class)
    @Override
    public CommonResult addGoods(AddGoodsReq req) {
        if (StringUtils.isBlank(req.getGoodName()) || Objects.isNull(req.getCategoryId())) {
            return CommonResult.fail(ResultCode.PARA_IS_EMPTY.getCode(), ResultCode.PARA_IS_EMPTY.getMsg());
        }
        Goods goods = new Goods();
        GoodsPrice goodsPrice = new GoodsPrice();
        CommonUtils.convert(goods, req);
        CommonUtils.convert(goodsPrice, req);
        Date date = new Date();
        goods.setCreateTime(date);
        goodsPrice.setCreateTime(date);
        String goodCode = req.getGoodCode();
        if (StringUtils.isBlank(goodCode)) {
            do {
                goodCode = CommonUtils.productNo(10);
            } while (Objects.nonNull(goodsMapper.queryByGoodCode(goodCode)));
        }
        Map<String, Object> paraMap = new HashMap<>(3);
        paraMap.put("goodCode", goodCode);
        paraMap.put("categoryId", req.getCategoryId());
        if (Objects.nonNull(relationMapper.queryRelation(paraMap))) {
            return CommonResult.fail(ResultCode.GOODS_CATEGORY_IS_EXIST.getCode(), ResultCode.GOODS_CATEGORY_IS_EXIST.getMsg());
        }
        goods.setGoodCode(goodCode);
        goodsPrice.setGoodCode(goodCode);
        goodsMapper.addGoods(goods);
        goodsPriceMapper.addGoodsPrice(goodsPrice);
        GoodsCategoryRelation relation = new GoodsCategoryRelation();
        relation.setCreateTime(date);
        relation.setCategoryId(req.getCategoryId());
        relation.setGoodCode(goodCode);
        relationMapper.add(relation);
        return CommonResult.success();
    }
}