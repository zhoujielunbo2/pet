package com.example.logistics.controller;

import com.example.logistics.annotation.LoginRequired;
import com.example.logistics.common.CommonResponse;
import com.example.logistics.common.CommonResult;
import com.example.logistics.domain.req.category.CategoryReq;
import com.example.logistics.service.CategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;

/**
 * @author hexiaobo
 * @title: CategoryController
 * @projectName logistics
 * @description: CategoryController
 * @date 2019/5/10 20:06
 */
@RestController
@RequestMapping("/category")
@Slf4j
public class CategoryController {
    @Autowired
    private CategoryService categoryService;
    /**
     * 新增分类
     *
     * @param categoryReq
     * @return
     */
    @LoginRequired
    @PostMapping("/addCategory")
    public CommonResponse addCategory(@RequestBody CategoryReq categoryReq, HttpServletRequest request) {
        CommonResult commonResult = categoryService.add(categoryReq);
        return CommonResponse.common(commonResult.getCode(), commonResult.getMessage(), commonResult.getData());
    }

}