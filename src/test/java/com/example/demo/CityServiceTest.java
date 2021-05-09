package com.example.demo;

import com.alibaba.fastjson.JSON;
import com.example.logistics.domain.bean.City;
import com.example.logistics.service.CityService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

/**
 * @author hexiaobo
 * @title: CityServiceTest
 * @projectName logistics
 * @description: CityServiceTest
 * @date 2019/5/7 15:16
 */
public class CityServiceTest extends UserServiceTests {
    @Autowired
    private CityService cityService;

    @Test
    public void queryAllProvinceListTest(){
        List<City>  cityList=cityService.queryAllProvinceList();
        System.out.println(cityList);
    }

    @Test
    public void queryCityOrAreaByIdListTest(){
        List<City>  cityList=cityService.queryCityOrAreaByIdList(14);
        System.out.println(JSON.toJSONString(cityList));
    }


    @Test
    public void queryAllCityListTest(){
        List<City>  cityList=cityService.queryAllCityList();
        System.out.println(JSON.toJSONString(cityList));
    }
}