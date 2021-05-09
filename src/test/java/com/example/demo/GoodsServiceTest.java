package com.example.demo;
import com.example.logistics.common.CommonResult;
import com.example.logistics.domain.req.goods.AddGoodsReq;
import com.example.logistics.service.GoodsService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import java.math.BigDecimal;


/**
 * @author hexiaobo
 * @title: CityServiceTest
 * @projectName logistics
 * @description: CityServiceTest
 * @date 2019/5/7 15:16
 */
public class GoodsServiceTest extends UserServiceTests {
    @Autowired
    private GoodsService goodsService;

    @Test
    public void  addGoodsTest(){
        AddGoodsReq addGoodsReq=new AddGoodsReq();
        addGoodsReq.setGoodStock(13);
        addGoodsReq.setBasePrice(new BigDecimal(10));
        addGoodsReq.setGoodName("矿泉水");
        addGoodsReq.setMemberPrice(new BigDecimal(5));
        addGoodsReq.setSalePrice(new BigDecimal(20));
        addGoodsReq.setCategoryId(1L);
        addGoodsReq.setGoodCode("zhoujielun");
        CommonResult commonResult=goodsService.addGoods(addGoodsReq);
        System.out.println(commonResult);
    }

}