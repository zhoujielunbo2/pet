package com.example.logistics.mapper;

import com.example.logistics.domain.bean.GoodsPrice;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author hexiaobo
 * @title: GoodsPriceMapper
 * @projectName logistics
 * @description: GoodsPriceMapper
 * @date 2019/5/11 20:57
 */
public interface GoodsPriceMapper {
    /**
     * 新增商品价格
     * @param goodsPrice
     */
    void addGoodsPrice(GoodsPrice goodsPrice);
    /**
     * 查询商品价格
     * @param code
     * @return
     */
    GoodsPrice queryGoodPriceByCode(String code);

    /**
     * 查询商品价格(批量)
     * @param codeList
     * @return
     */
    List<GoodsPrice> queryGoodPriceByCodeList(@Param("codeList") List<String> codeList);

}
