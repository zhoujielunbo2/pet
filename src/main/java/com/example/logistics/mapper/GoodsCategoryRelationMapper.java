package com.example.logistics.mapper;

import com.example.logistics.domain.bean.GoodsCategoryRelation;

import java.util.Map;

/**
 * @author hexiaobo
 * @title: GoodsCategoryRelationMapper
 * @projectName logistics
 * @description: GoodsCategoryRelationMapper
 * @date 2019/5/11 12:00
 */
public interface GoodsCategoryRelationMapper {
    /**
     * 新增
     * @param relation
     */
    void add(GoodsCategoryRelation relation);

    /**
     *查询
     * @param paraMap
     * @return
     */
    GoodsCategoryRelation queryRelation(Map<String,Object> paraMap);
}
