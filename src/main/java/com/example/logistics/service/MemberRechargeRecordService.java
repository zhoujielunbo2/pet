package com.example.logistics.service;

import com.example.logistics.common.CommonResult;
import com.example.logistics.domain.req.member.AddMemberRechargeReq;

/**
 * @author hexiaobo
 * @title: MemberRechargeRecordService
 * @projectName logistics
 * @description: MemberRechargeRecordService
 * @date 2019/5/10 17:42
 */
public interface MemberRechargeRecordService {

    CommonResult add(AddMemberRechargeReq req);
}
