package com.example.logistics.controller;

import com.example.logistics.service.GoodsCategoryRelationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author hexiaobo
 * @title: GoodsCategoryRelationController
 * @projectName logistics
 * @description: GoodsCategoryRelationController
 * @date 2019/5/10 20:06
 */
@RestController
@RequestMapping("/categoryRelation")
@Slf4j
public class GoodsCategoryRelationController {
    @Autowired
    private GoodsCategoryRelationService goodsCategoryRelationService;
}