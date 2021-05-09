package com.example.logistics.domain.bean;

import lombok.Data;
import java.util.Date;

/**
 * @author hexiaobo
 * @title: Category
 * @projectName logistics
 * @description: Category
 * @date 2019/5/10 20:04
 */
@Data
public class Category {
    private String categoryCode;
    private String categoryName;
    private Long parentId;
    /**
     * 是否是最底层分类 1：是 2:否
     */
    private Integer isEnd;
    private Date createTime;
}