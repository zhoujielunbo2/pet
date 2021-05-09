package com.example.demo;

import com.example.logistics.common.CommonResult;
import com.example.logistics.domain.req.member.AddMemberReq;
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
public class MemberServiceTest extends UserServiceTests {
    @Autowired
    private MemberService memberService;

    @Test
    public void addMemberTest(){
        AddMemberReq req=new AddMemberReq();
        req.setPhone("13723726239");
        req.setBalance(new BigDecimal("121"));
        req.setShopName("七里香");
        CommonResult commonResult=memberService.addMember(req);
        System.out.println(commonResult);
    }

    @Test
    public void queryMemberByConditionTest(){
        CommonResult commonResult=memberService.queryMemberByCondition("七里");
        System.out.println(commonResult);
    }



}