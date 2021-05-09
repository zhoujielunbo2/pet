package com.example.logistics.mapper;

import com.example.logistics.domain.bean.City;

import java.util.List;

/**
 * @author hexiaobo
 * @title: CityMapper
 * @projectName logistics
 * @description: CityMapper
 * @date 2019/5/7 15:36
 */
public interface CityMapper {
    /**
     * 查询所有的省
     * @return
     */
    List<City> queryAllProvinceList();

    /**
     * 查询所有的城市
     * @return
     */
    List<City> queryAllCityList();

    /**
     * 查询省下辖市或市下辖区
     * @param pid
     * @return
     */
    List<City> queryCityOrAreaByIdList(Integer pid);
}
