package com.example.logistics.service;

import com.example.logistics.common.CommonResult;
import com.example.logistics.domain.req.category.CategoryReq;

/**
 * @author hexiaobo
 * @title: CategoryService
 * @projectName logistics
 * @description: CategoryService
 * @date 2019/5/10 20:05
 */
public interface CategoryService {
    /**
     * 新增分类
     * @param categoryReq
     * @return
     */
    CommonResult add(CategoryReq categoryReq);
}
