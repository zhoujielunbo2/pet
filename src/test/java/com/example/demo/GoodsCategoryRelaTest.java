package com.example.demo;

import com.example.logistics.common.CommonResult;
import com.example.logistics.domain.req.category.CategoryReq;
import com.example.logistics.domain.req.goodscatrela.GoodsCategoryRelationReq;
import com.example.logistics.service.CategoryService;
import com.example.logistics.service.GoodsCategoryRelationService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author hexiaobo
 * @title: CityServiceTest
 * @projectName logistics
 * @description: CityServiceTest
 * @date 2019/5/7 15:16
 */
public class GoodsCategoryRelaTest extends UserServiceTests {
    @Autowired
    private GoodsCategoryRelationService categoryService;

    @Test
    public void addTest() {
        GoodsCategoryRelationReq relationReq=new GoodsCategoryRelationReq();
        relationReq.setGoodCode("133");
        relationReq.setCategoryId(12L);
        CommonResult commonResult=categoryService.add(relationReq);
        System.out.println(commonResult);
    }

}