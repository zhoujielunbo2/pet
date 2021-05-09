package com.example.demo;

import com.example.logistics.common.CommonResult;
import com.example.logistics.domain.req.member.AddMemberRechargeReq;
import com.example.logistics.domain.req.member.AddMemberReq;
import com.example.logistics.service.MemberRechargeRecordService;
import com.example.logistics.service.MemberService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

/**
 * @author hexiaobo
 * @title: CityServiceTest
 * @projectName logistics
 * @description: CityServiceTest
 * @date 2019/5/7 15:16
 */
public class MemberRechageServiceTest extends UserServiceTests {
    @Autowired
    private MemberRechargeRecordService memberService;

    @Test
    public void  addTest(){
        AddMemberRechargeReq rechargeReq=new AddMemberRechargeReq();
        rechargeReq.setCode("111");
        rechargeReq.setGiveAmount(new BigDecimal("10"));
        rechargeReq.setRechargeAmount(new BigDecimal("10"));
        rechargeReq.setShopNo("dajdaj");
        CommonResult commonResult=memberService.add(rechargeReq);
        System.out.println(commonResult);
    }
}