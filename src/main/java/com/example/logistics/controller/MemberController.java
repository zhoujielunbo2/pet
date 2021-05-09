package com.example.logistics.controller;

import com.example.logistics.annotation.LoginRequired;
import com.example.logistics.common.CommonResponse;
import com.example.logistics.common.CommonResult;
import com.example.logistics.domain.req.member.AddMemberReq;
import com.example.logistics.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @author hexiaobo
 * @title: MemberController
 * @projectName logistics
 * @description: MemberController
 * @date 2019/5/7 17:59
 */
@RestController
@RequestMapping("/member")
@Slf4j
public class MemberController {

    @Autowired
    private MemberService memberService;

    /**
     * 新增会员
     *
     * @param addMemberReq
     * @return
     */
    @LoginRequired
    @PostMapping("/addMember")
    public CommonResponse addMember(@RequestBody AddMemberReq addMemberReq, HttpServletRequest request) {
        CommonResult commonResult = memberService.addMember(addMemberReq);
        return CommonResponse.common(commonResult.getCode(), commonResult.getMessage(), commonResult.getData());
    }

    /**
     * 根据条件查询会员信息
     *
     * @param condition
     * @return
     */
    @LoginRequired
    @GetMapping("/queryMemberByCondition")
    public CommonResponse queryMemberByCondition(String condition) {
        CommonResult commonResult = memberService.queryMemberByCondition(condition);
        return CommonResponse.common(commonResult.getCode(), commonResult.getMessage(), commonResult.getData());
    }
}