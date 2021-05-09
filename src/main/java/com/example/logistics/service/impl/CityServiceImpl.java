package com.example.logistics.service.impl;

import com.example.logistics.domain.bean.City;
import com.example.logistics.mapper.CityMapper;
import com.example.logistics.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * @author hexiaobo
 * @title: CityServiceImpl
 * @projectName logistics
 * @description: CityServiceImpl
 * @date 2019/5/7 15:40
 */
@Service
public class CityServiceImpl implements CityService {
    @Autowired
    private CityMapper cityMapper;
    @Override
    public List<City> queryAllProvinceList() {
        return cityMapper.queryAllProvinceList();
    }

    @Override
    public List<City> queryAllCityList() {
        return cityMapper.queryAllCityList();
    }

    @Override
    public List<City> queryCityOrAreaByIdList(Integer pid) {
        return cityMapper.queryCityOrAreaByIdList(pid);
    }
}