package com.example.logistics.domain.req.category;

import lombok.Data;

/**
 * @author hexiaobo
 * @title: CategoryReq
 * @projectName logistics
 * @description: CategoryReq
 * @date 2019/5/11 13:45
 */
@Data
public class CategoryReq {
    /**
     * 分类名称
     */
    private String categoryName;
    /**
     * 没有 输入0
     */
    private Long parentId;
    /**
     * 是否是最底层分类 1：是 2:否
     */
    private Integer isEnd;
}