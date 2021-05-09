package com.example.logistics.mapper;

import com.example.logistics.domain.bean.Shop;

import java.util.List;

/**
 * @author hexiaobo
 * @title: ShopMapper
 * @projectName logistics
 * @description: ShopMapper
 * @date 2019/5/1 14:29
 */
public interface ShopMapper {

    /**
     * 新增店铺
     * @param shop
     */
    void addShop(Shop shop);

    /**
     * 更新店铺
     * @param shop
     */
    void  updateShow(Shop shop);

    /**
     * 根据门店编号查询
     * @param shopNo
     * @return
     */
    Shop queryShopByNo(String shopNo);

    /**
     * 根据用户id查询店铺列表
     * @param phone
     * @return
     */
    List<Shop> queryShopListByPhone(String phone);
}
