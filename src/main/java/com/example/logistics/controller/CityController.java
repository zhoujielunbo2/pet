package com.example.logistics.controller;

import com.example.logistics.common.CommonResponse;
import com.example.logistics.service.CityService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author hexiaobo
 * @title: CityController
 * @projectName logistics
 * @description: CityController
 * @date 2019/5/7 15:31
 */
@RestController
@RequestMapping("/city")
@Slf4j
public class CityController {

    @Autowired
    private CityService cityService;

    /**
     * 查询所有省份
     *
     * @return
     */
    @GetMapping("/queryAllProvinceList")
    public CommonResponse queryAllProvinceList() {
        return CommonResponse.success(cityService.queryAllProvinceList());
    }

    /**
     * 查询所有城市
     *
     * @return
     */
    @GetMapping("/queryAllCityList")
    public CommonResponse queryAllCityList() {
        return CommonResponse.success(cityService.queryAllCityList());
    }

    /**
     * 查询省下辖市或市下辖区
     *
     * @param pid
     * @return
     */
    @GetMapping("/queryCityOrAreaByIdList")
    public CommonResponse queryCityOrAreaByIdList(Integer pid) {
        return CommonResponse.success(cityService.queryCityOrAreaByIdList(pid));
    }

}