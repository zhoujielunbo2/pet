package com.example.logistics.domain.req.city;

import lombok.Data;

import java.io.Serializable;

/**
 * @author hexiaobo
 * @title: QueryCityReq
 * @projectName logistics
 * @description: QueryCityReq
 * @date 2019/5/7 15:37
 */
@Data
public class QueryCityReq implements Serializable {

    private Integer pid;
}