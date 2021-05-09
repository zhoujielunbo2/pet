package com.example.logistics.controller;
import com.example.logistics.annotation.LoginRequired;
import com.example.logistics.common.CommonResponse;
import com.example.logistics.common.CommonResult;
import com.example.logistics.domain.req.cart.AddCartListReq;
import com.example.logistics.service.CartService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;

/**
 * @author hexiaobo
 * @title: CartController
 * @projectName logistics
 * @description: CartController
 * @date 2019/5/12 19:50
 */
@RestController
@RequestMapping("/cart")
@Slf4j
public class CartController {

    @Autowired
    private CartService cartService;
    /**
     * 计算机购物车总金额
     *
     * @param req
     * @return
     */
    @LoginRequired
    @PostMapping("/calculateTotalAmount")
    public CommonResponse calculateTotalAmount(@RequestBody AddCartListReq req, HttpServletRequest request) {
        CommonResult commonResult = cartService.calculateTotalAmount(req);
        return CommonResponse.common(commonResult.getCode(), commonResult.getMessage(), commonResult.getData());
    }
}