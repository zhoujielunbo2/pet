package com.example.demo;

import com.example.logistics.common.CommonResult;
import com.example.logistics.domain.req.cart.AddCartListReq;
import com.example.logistics.domain.req.cart.AddCartReq;
import com.example.logistics.service.CartService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hexiaobo
 * @title: CityServiceTest
 * @projectName logistics
 * @description: CityServiceTest
 * @date 2019/5/7 15:16
 */
public class CartServiceTest extends UserServiceTests {
    @Autowired
    private CartService cartService;

    @Test
    public void calculateTotalAmountTest(){
        AddCartListReq listReq=new AddCartListReq();
//        listReq.setCode("111");
//        listReq.setShopNo("6Z5U3S9P9A");
        List<AddCartReq> goodsList=new ArrayList<>();
        AddCartReq addCartReq=new AddCartReq();
        addCartReq.setGoodCode("8P6B2V1Q4E2M1E6O9Q6W6G");
        addCartReq.setNum(12);
        goodsList.add(addCartReq);
        listReq.setGoodsList(goodsList);
        CommonResult commonResult=cartService.calculateTotalAmount(listReq);
        System.out.println(commonResult);
    }
}