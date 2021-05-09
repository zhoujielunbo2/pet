package com.example.logistics.mapper;

import com.example.logistics.domain.bean.Member;

import java.util.List;
import java.util.Map;

/**
 * @author hexiaobo
 * @title: MemberMapper
 * @projectName logistics
 * @description: MemberMapper
 * @date 2019/5/7 17:58
 */
public interface MemberMapper {
    /**
     * 新增会员
     * @param member
     */
    void  addMember(Member member);

    /**
     * 根据手机号查询会员
     * @param phone
     * @return
     */
    Member queryMemberByPhone(String phone);

    /**
     * 根据会员卡号和门店号查询会员
     * @param balanceMap
     * @return
     */
    Member queryMemberByCodeShopNo(Map<String,Object> balanceMap);

    /**
     *根据条件查询会员信息(输入信息 可能是有可能是手机号码，有可能是卡号，有可能是姓名)
     * @param condition
     * @return
     */
    List<Member> queryMemberByCondition(String condition);

    /**
     * 更新余额
     * @param balanceMap
     */
    void updateBalance(Map<String,Object> balanceMap);
}
