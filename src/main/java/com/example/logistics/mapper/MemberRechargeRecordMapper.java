package com.example.logistics.mapper;

import com.example.logistics.domain.bean.MemberRechargeRecord;

/**
 * @author hexiaobo
 * @title: MemberRechargeRecordMapper
 * @projectName logistics
 * @description: MemberRechargeRecordMapper
 * @date 2019/5/10 17:35
 */
public interface MemberRechargeRecordMapper {
    void add(MemberRechargeRecord rechargeRecord);

    MemberRechargeRecord queryRecordByCodeShopNo(String code);
}
