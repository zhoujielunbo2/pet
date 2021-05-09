package com.example.logistics.service.impl;
import com.example.logistics.common.CommonResult;
import com.example.logistics.domain.bean.Shop;
import com.example.logistics.domain.req.shop.AddShopReq;
import com.example.logistics.mapper.ShopMapper;
import com.example.logistics.service.ShopService;
import com.example.logistics.util.CommonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author hexiaobo
 * @title: ShopServiceImpl
 * @projectName logistics
 * @description: ShopServiceImpl
 * @date 2019/5/1 14:47
 */
@Service
public class ShopServiceImpl implements ShopService {
    @Autowired
    private  ShopMapper shopMapper;
    @Override
    public CommonResult addShop(AddShopReq addShopReq) {
        CommonResult commonResult=new CommonResult();
        Shop shop=new Shop();
        CommonUtils.convert(shop,addShopReq);
        String shopNo;
        do {
            shopNo=CommonUtils.productNo(4);
        }while (Objects.nonNull(shopMapper.queryShopByNo(shopNo)));
        shop.setShopNo(shopNo);
        shop.setIsCloseVIP(addShopReq.isCloseVIP()?1:2);
        shopMapper.addShop(shop);
        return commonResult;
    }

}