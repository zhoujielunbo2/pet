package com.example.logistics.service;

import com.example.logistics.common.CommonResult;
import com.example.logistics.domain.req.goodscatrela.GoodsCategoryRelationReq;

/**
 * @author hexiaobo
 * @title: GoodsCategoryRelaService
 * @projectName logistics
 * @description: GoodsCategoryRelaService
 * @date 2019/5/11 11:59
 */
public interface GoodsCategoryRelationService {
    /**
     * 新增
     * @param req
     * @return
     */
    CommonResult add(GoodsCategoryRelationReq req);
}
