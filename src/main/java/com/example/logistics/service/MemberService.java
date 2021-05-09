package com.example.logistics.service;

import com.example.logistics.common.CommonResult;
import com.example.logistics.domain.req.member.AddMemberReq;

/**
 * @author hexiaobo
 * @title: MemberService
 * @projectName logistics
 * @description: MemberService
 * @date 2019/5/7 17:58
 */
public interface MemberService {
    /**
     * 新增会员
     * @param addMemberReq
     * @return
     */
    CommonResult addMember(AddMemberReq addMemberReq);

    /**
     * 根据条件查询会员信息(输入信息 可能是有可能是手机号码，有可能是卡号，有可能是姓名)
     * @param condition
     * @return
     */
    CommonResult queryMemberByCondition(String condition);
}
