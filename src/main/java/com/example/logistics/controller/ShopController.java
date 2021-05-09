package com.example.logistics.controller;

import com.example.logistics.annotation.LoginRequired;
import com.example.logistics.common.CommonResponse;
import com.example.logistics.common.CommonResult;
import com.example.logistics.domain.req.shop.AddShopReq;
import com.example.logistics.service.ShopService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author hexiaobo
 * @title: ShopController
 * @projectName logistics
 * @description: ShopController
 * @date 2019/5/1 14:28
 */
@RestController
@RequestMapping("/shop")
@Slf4j
public class ShopController {
    @Autowired
    private ShopService shopService;

    /**
     * 新增店铺
     *
     * @param addShopReq
     * @return
     */
    @LoginRequired
    @PostMapping("/addShop")
    public CommonResponse addShop(@RequestBody AddShopReq addShopReq, HttpServletRequest request) {
        CommonResult commonResult = shopService.addShop(addShopReq);
        return CommonResponse.common(commonResult.getCode(), commonResult.getMessage(), commonResult.getData());
    }

}