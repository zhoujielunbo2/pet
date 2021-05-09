package com.example.logistics.controller;

import com.example.logistics.annotation.LoginRequired;
import com.example.logistics.common.CommonResponse;
import com.example.logistics.common.CommonResult;
import com.example.logistics.domain.req.member.AddMemberRechargeReq;
import com.example.logistics.service.MemberRechargeRecordService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author hexiaobo
 * @title: MemberRechargeRecordController
 * @projectName logistics
 * @description: MemberRechargeRecordController
 * @date 2019/5/10 17:53
 */
@RestController
@RequestMapping("/memberRechargeRecord")
@Slf4j
public class MemberRechargeRecordController {

    @Autowired
    private MemberRechargeRecordService memberRechargeRecordService;
    /**
     * 新增充值记录
     * @param rechargeReq
     * @return
     */
    @LoginRequired
    @PostMapping("/addMemberRechargeRecord")
    public CommonResponse addMemberRechargeRecord(@RequestBody AddMemberRechargeReq rechargeReq, HttpServletRequest request) {
        CommonResult commonResult = memberRechargeRecordService.add(rechargeReq);
        return CommonResponse.common(commonResult.getCode(), commonResult.getMessage(), commonResult.getData());
    }
}