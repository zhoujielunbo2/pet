package com.example.demo;

import com.example.logistics.common.CommonResult;
import com.example.logistics.domain.req.shop.AddShopReq;
import com.example.logistics.service.ShopService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author hexiaobo
 * @title: ShopServiceTest
 * @projectName logistics
 * @description: ShopServiceTest
 * @date 2019/5/7 15:16
 */
public class ShopServiceTest extends UserServiceTests {
    @Autowired
    private ShopService shopService;

    @Test
    public void addShowTest() {
        AddShopReq addShopReq = new AddShopReq();
        addShopReq.setArea("嘉鱼县");
        addShopReq.setAreaId(1L);
        addShopReq.setCity("咸宁");
        addShopReq.setCityId(2L);
        addShopReq.setCloseVIP(false);
        addShopReq.setProvince("湖北");
        addShopReq.setProvinceId(3L);
        addShopReq.setShopAddress("渡普镇邮政局");
        addShopReq.setShopName("七里香饺子");
        addShopReq.setShopOwner("贺晓波");
        addShopReq.setShopStatus(1);
        addShopReq.setShopTel("13723726239");
        addShopReq.setPhone("13723726239");
        CommonResult commonResult = shopService.addShop(addShopReq);
        System.out.println(commonResult);
    }
}