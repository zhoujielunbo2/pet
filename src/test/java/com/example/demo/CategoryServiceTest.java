package com.example.demo;

import com.example.logistics.domain.req.category.CategoryReq;
import com.example.logistics.service.CategoryService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author hexiaobo
 * @title: CityServiceTest
 * @projectName logistics
 * @description: CityServiceTest
 * @date 2019/5/7 15:16
 */
public class CategoryServiceTest extends UserServiceTests {
    @Autowired
    private CategoryService categoryService;

    @Test
    public void addTest() {
        CategoryReq categoryReq=new CategoryReq();
        categoryReq.setParentId(0L);
        categoryReq.setCategoryName("蔬菜");
        categoryReq.setIsEnd(2);
        categoryService.add(categoryReq);
    }

}