package com.example.logistics.controller;

import com.example.logistics.annotation.LoginRequired;
import com.example.logistics.common.CommonResponse;
import com.example.logistics.common.CommonResult;
import com.example.logistics.domain.req.goods.AddGoodsReq;
import com.example.logistics.service.GoodsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author hexiaobo
 * @title: GoodsController
 * @projectName logistics
 * @description: GoodsController
 * @date 2019/5/10 20:05
 */
@RestController
@RequestMapping("/goods")
@Slf4j
public class GoodsController {
    @Autowired
    private GoodsService goodsService;
    /**
     * 新增商品
     *
     * @param req
     * @return
     */
    @LoginRequired
    @PostMapping("/addGoods")
    public CommonResponse addGoods(@RequestBody AddGoodsReq req, HttpServletRequest request) {
        CommonResult commonResult = goodsService.addGoods(req);
        return CommonResponse.common(commonResult.getCode(), commonResult.getMessage(), commonResult.getData());
    }


}