package com.example.logistics.service.impl;
import com.example.logistics.common.CommonResult;
import com.example.logistics.domain.bean.GoodsCategoryRelation;
import com.example.logistics.domain.req.goodscatrela.GoodsCategoryRelationReq;
import com.example.logistics.enums.ResultCode;
import com.example.logistics.mapper.GoodsCategoryRelationMapper;
import com.example.logistics.service.GoodsCategoryRelationService;
import com.example.logistics.util.CommonUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author hexiaobo
 * @title: GoodsCategoryRelationServiceImpl
 * @projectName logistics
 * @description: GoodsCategoryRelationServiceImpl
 * @date 2019/5/11 11:59
 */
@Service
public class GoodsCategoryRelationServiceImpl implements GoodsCategoryRelationService {
    @Autowired
    private GoodsCategoryRelationMapper mapper;
    @Override
    public CommonResult add(GoodsCategoryRelationReq req) {
        if(StringUtils.isBlank(req.getGoodCode())||Objects.isNull(req.getCategoryId())){
            return CommonResult.fail(ResultCode.PARA_IS_EMPTY.getCode(),ResultCode.PARA_IS_EMPTY.getMsg());
        }
        Map<String,Object> map=new HashMap<>(3);
        map.put("goodCode",req.getGoodCode());
        map.put("categoryId",req.getCategoryId());
        if(Objects.nonNull(mapper.queryRelation(map))){
            return CommonResult.fail(ResultCode.RECORD_IS_EXIST.getCode(),ResultCode.RECORD_IS_EXIST.getMsg());
        }
        GoodsCategoryRelation relation=new GoodsCategoryRelation();
        CommonUtils.convert(relation,req);
        relation.setCreateTime(new Date());
        mapper.add(relation);
        return CommonResult.success();
    }
}