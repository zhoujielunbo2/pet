package com.example.logistics.service.impl;

import com.example.logistics.common.CommonResult;
import com.example.logistics.domain.bean.Category;
import com.example.logistics.domain.req.category.CategoryReq;
import com.example.logistics.enums.ResultCode;
import com.example.logistics.mapper.CategoryMapper;
import com.example.logistics.service.CategoryService;
import com.example.logistics.util.CommonUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Objects;

/**
 * @author hexiaobo
 * @title: CategoryServiceImpl
 * @projectName logistics
 * @description: CategoryServiceImpl
 * @date 2019/5/10 20:05
 */
@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryMapper categoryMapper;
    @Override
    public CommonResult add(CategoryReq categoryReq) {
        if(StringUtils.isBlank(categoryReq.getCategoryName())|| Objects.isNull(categoryReq.getIsEnd())
                ||Objects.isNull(categoryReq.getParentId())){
            return CommonResult.fail(ResultCode.PARA_IS_EMPTY.getCode(),ResultCode.PARA_IS_EMPTY.getMsg());
        }
        String categoryCode;
        do {
            categoryCode= CommonUtils.productNo(4);
        }while(Objects.nonNull(categoryMapper.queryCatByCode(categoryCode)));
        Category category=new Category();
        CommonUtils.convert(category,categoryReq);
        category.setCreateTime(new Date());
        category.setCategoryCode(categoryCode);
        categoryMapper.add(category);
        return CommonResult.success();
    }
}