package com.example.logistics.domain.bean;

import lombok.Data;

/**
 * @author hexiaobo
 * @title: City
 * @projectName logistics
 * @description: City
 * @date 2019/5/7 15:32
 */
@Data
public class City {
    private Integer id;
    /**
     * 父级id
     */
    private Integer pid;
    /**
     * 名称
     */
    private String cityName;
    /**
     * 类型  0：中国 1:省 2：市 3:区
     */
    private Integer type;

}