package com.example.logistics.mapper;
import com.example.logistics.domain.bean.OrderInfo;
/**
 * @author hexiaobo
 * @title: OrderInfoMapper
 * @projectName logistics
 * @description: OrderInfoMapper
 * @date 2019/5/12 20:29
 */
public interface OrderInfoMapper {
    /**
     * 创建订单
     * @param orderInfo
     */
    void  createOrderInfo(OrderInfo orderInfo);
}
