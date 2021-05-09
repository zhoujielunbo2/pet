package com.example.logistics.service.impl;

import com.example.logistics.common.CommonResult;
import com.example.logistics.domain.bean.Member;
import com.example.logistics.domain.bean.MemberRechargeRecord;
import com.example.logistics.domain.req.member.AddMemberRechargeReq;
import com.example.logistics.enums.ResultCode;
import com.example.logistics.mapper.MemberMapper;
import com.example.logistics.mapper.MemberRechargeRecordMapper;
import com.example.logistics.service.MemberRechargeRecordService;
import com.example.logistics.util.CommonUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author hexiaobo
 * @title: MemberRechargeRecordServiceImpl
 * @projectName logistics
 * @description: MemberRechargeRecordServiceImpl
 * @date 2019/5/10 17:42
 */
@Service
public class MemberRechargeRecordServiceImpl implements MemberRechargeRecordService {
    @Autowired
    private MemberRechargeRecordMapper mapper;
    @Autowired
    private MemberMapper memberMapper;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public CommonResult add(AddMemberRechargeReq req) {
        if (StringUtils.isBlank(req.getCode()) || StringUtils.isBlank(req.getShopNo())) {
            return CommonResult.fail(ResultCode.PARA_IS_EMPTY.getCode(), ResultCode.PARA_IS_EMPTY.getMsg());
        }
        Map<String, Object> map = new HashMap<>(3);
        map.put("shopNo", req.getShopNo());
        map.put("code", req.getCode());
        Member member = memberMapper.queryMemberByCodeShopNo(map);
        if (Objects.isNull(member)) {
            return CommonResult.fail(ResultCode.CODE_IS_NOT_EXIST.getCode(), ResultCode.CODE_IS_NOT_EXIST.getMsg());
        }
        MemberRechargeRecord rechargeRecord = new MemberRechargeRecord();
        CommonUtils.convert(rechargeRecord, req);
        rechargeRecord.setCreateTime(new Date());
        mapper.add(rechargeRecord);
        map.put("amount", req.getGiveAmount().add(req.getRechargeAmount()));
        memberMapper.updateBalance(map);
        return CommonResult.success();
    }
}