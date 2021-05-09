package com.example.logistics.service.impl;
import com.example.logistics.common.CommonResult;
import com.example.logistics.domain.bean.Member;
import com.example.logistics.domain.req.member.AddMemberReq;
import com.example.logistics.domain.resp.MemberResp;
import com.example.logistics.enums.ResultCode;
import com.example.logistics.mapper.MemberMapper;
import com.example.logistics.service.MemberService;
import com.example.logistics.util.CommonUtils;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * @author hexiaobo
 * @title: MemberServiceImpl
 * @projectName logistics
 * @description: MemberServiceImpl
 * @date 2019/5/9 19:06
 */
@Service
public class MemberServiceImpl implements MemberService {
    @Autowired
    private MemberMapper memberMapper;
    @Override
    public CommonResult addMember(AddMemberReq addMemberReq) {
        if(StringUtils.isBlank(addMemberReq.getPhone())||Objects.isNull(addMemberReq.getShopNo())){
            return CommonResult.fail(ResultCode.PARA_IS_EMPTY.getCode(),ResultCode.PARA_IS_EMPTY.getMsg());
        }
        if(Objects.nonNull(memberMapper.queryMemberByPhone(addMemberReq.getPhone()))){
            return CommonResult.fail(ResultCode.PHONE_IS_EXIST.getCode(),ResultCode.PHONE_IS_EXIST.getMsg());
        }
        if(Objects.nonNull(addMemberReq.getIsPwd())&&1==addMemberReq.getIsPwd()&&StringUtils.isBlank(addMemberReq.getPassword())){
            return CommonResult.fail(ResultCode.PASSWORD_OIS_NOT_EMPTY.getCode(),ResultCode.PASSWORD_OIS_NOT_EMPTY.getMsg());
        }
        Member member= new Member();
        CommonUtils.convert(member,addMemberReq);
        if(StringUtils.isBlank(member.getCode())){
            member.setCode(addMemberReq.getPhone());
        }
        member.setCreateDate(new Date());
        member.setOnCredit(addMemberReq.isOnCredit()?2:1);
        memberMapper.addMember(member);
        return new CommonResult();
    }
    @Override
    public CommonResult queryMemberByCondition(String condition) {
        List<Member> memberList=memberMapper.queryMemberByCondition(condition);
         List<MemberResp> respList=new ArrayList<>();
        MemberResp resp;
         if(CollectionUtils.isNotEmpty(memberList)){
             for(Member member:memberList){
                 resp=new MemberResp();
                 CommonUtils.convert(resp,member);
                 resp.setOnCredit(member.getOnCredit()==1);
                 respList.add(resp);
             }
         }
        return CommonResult.success(respList);
    }
}