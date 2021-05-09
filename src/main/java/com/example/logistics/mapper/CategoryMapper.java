package com.example.logistics.mapper;

import com.example.logistics.domain.bean.Category;

/**
 * @author hexiaobo
 * @title: CategoryMapper
 * @projectName logistics
 * @description: CategoryMapper
 * @date 2019/5/10 20:04
 */
public interface CategoryMapper {
    /**
     * 新增分类
     * @param category
     */
    void add(Category category);

    /**
     * 根据code查询分类
     * @param categoryCode
     * @return
     */
    Category queryCatByCode(String categoryCode);

}
