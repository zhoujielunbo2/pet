package com.example.logistics.mapper;
import com.example.logistics.domain.bean.Goods;

/**
 * @author hexiaobo
 * @title: GoodsMapper
 * @projectName logistics
 * @description: GoodsMapper
 * @date 2019/5/10 20:04
 */
public interface GoodsMapper {
    /**
     * 新增商品
     * @param goods
     */
    void addGoods(Goods goods);

    /**
     * 根据商品编码查询商品
     * @param goodCode
     * @return
     */
    Goods queryByGoodCode(String goodCode);
}
