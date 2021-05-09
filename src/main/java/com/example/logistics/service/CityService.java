package com.example.logistics.service;

import com.example.logistics.domain.bean.City;

import java.util.List;

/**
 * @author hexiaobo
 * @title: CityService
 * @projectName logistics
 * @description: CityService
 * @date 2019/5/7 15:40
 */
public interface CityService {
    /**
     * 查询所有的省
     * @return
     */
    List<City> queryAllProvinceList();

    /**
     * 查询所有城市
     * @return
     */
    List<City> queryAllCityList();

    /**
     * queryCityOrAreaByIdList
     * @param pid
     * @return
     */
    List<City> queryCityOrAreaByIdList(Integer pid);
}
