package com.example.logistics.service.impl;
import com.alibaba.fastjson.JSON;
import com.example.logistics.common.CommonResult;
import com.example.logistics.domain.bean.GoodsPrice;
import com.example.logistics.domain.bean.Member;
import com.example.logistics.domain.req.cart.AddCartListReq;
import com.example.logistics.domain.req.cart.AddCartReq;
import com.example.logistics.domain.resp.CartCalculateResp;
import com.example.logistics.enums.ResultCode;
import com.example.logistics.mapper.GoodsPriceMapper;
import com.example.logistics.mapper.MemberMapper;
import com.example.logistics.service.CartService;
import com.example.logistics.util.AmountUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author hexiaobo
 * @title: CartServiceImpl
 * @projectName logistics
 * @description: CartServiceImpl
 * @date 2019/5/12 16:05
 */
@Service
@Slf4j
public class CartServiceImpl implements CartService {
    @Autowired
    private MemberMapper memberMapper;
    @Autowired
    private GoodsPriceMapper goodsPriceMapper;

    @Override
    public CommonResult calculateTotalAmount(AddCartListReq req) {
        List<AddCartReq> goodsList = req.getGoodsList();
        if (CollectionUtils.isEmpty(goodsList)) {
            return CommonResult.fail(ResultCode.PARA_IS_EMPTY.getCode(),ResultCode.PARA_IS_EMPTY.getMsg());
        }
        /**1:如果有会员 */
        String code = req.getCode();
        String shopNo = req.getShopNo();
        if (StringUtils.isNotBlank(code) && StringUtils.isNotBlank(shopNo)) {
            return memberCalculate(goodsList, code, shopNo);
        }
        return noMemberCalculate(goodsList);

    }

    /**
     * 非会员计算购物车总金额
     *
     * @param goodsList
     * @return
     */
    private CommonResult noMemberCalculate(List<AddCartReq> goodsList) {
        List<String> codeList = goodsList.stream().map(AddCartReq::getGoodCode).collect(Collectors.toList());
        log.info("codeList:{}", JSON.toJSONString(codeList));
        List<GoodsPrice> goodsPriceList = goodsPriceMapper.queryGoodPriceByCodeList(codeList);
        log.info("goodsPriceList:{}", JSON.toJSONString(goodsPriceList));
        if (codeList.size() != goodsPriceList.size()) {
            return CommonResult.fail(ResultCode.GOODS_IS_NOT_EXIST.getCode(), ResultCode.GOODS_IS_NOT_EXIST.getMsg());
        }
        BigDecimal totalAmount = BigDecimal.ZERO;
        for (GoodsPrice goodsPrice : goodsPriceList) {
            Optional<AddCartReq> addCartReqOptional = goodsList.stream().
                    filter(c -> c.getGoodCode().equals(goodsPrice.getGoodCode())).findFirst();
            AddCartReq cartReq = addCartReqOptional.get();
            BigDecimal salePrice = goodsPrice.getSalePrice();
            totalAmount = totalAmount.add(salePrice.multiply(new BigDecimal(cartReq.getNum())));
        }
        log.info("totalAmount:{}", totalAmount);
        CartCalculateResp resp = CartCalculateResp.builder().totalAmount(AmountUtils.setScaleTwo(totalAmount))
                .payAmount(totalAmount).build();
        return CommonResult.success(resp);
    }

    /**
     * 会员计算购物车总金额
     *
     * @param goodsList
     * @param code
     * @param shopNo
     * @return
     */
    private CommonResult memberCalculate(List<AddCartReq> goodsList, String code, String shopNo) {
        Map<String, Object> balanceMap = new HashMap<>(3);
        balanceMap.put("code", code);
        balanceMap.put("shopNo", shopNo);
        Member member = memberMapper.queryMemberByCodeShopNo(balanceMap);
        if (Objects.isNull(member)) {
            return CommonResult.fail(ResultCode.CODE_IS_NOT_EXIST.getCode(), ResultCode.CODE_IS_NOT_EXIST.getMsg());
        }
        List<String> codeList = goodsList.stream().map(AddCartReq::getGoodCode).collect(Collectors.toList());
        log.info("codeList:{}", JSON.toJSONString(codeList));
        List<GoodsPrice> goodsPriceList = goodsPriceMapper.queryGoodPriceByCodeList(codeList);
        log.info("goodsPriceList:{}", JSON.toJSONString(goodsPriceList));
        if (codeList.size() != goodsPriceList.size()) {
            return CommonResult.fail(ResultCode.GOODS_IS_NOT_EXIST.getCode(), ResultCode.GOODS_IS_NOT_EXIST.getMsg());
        }
        BigDecimal totalAmount = BigDecimal.ZERO;
        for (GoodsPrice goodsPrice : goodsPriceList) {
            Optional<AddCartReq> addCartReqOptional = goodsList.stream().
                    filter(c -> c.getGoodCode().equals(goodsPrice.getGoodCode())).findFirst();
            AddCartReq cartReq = addCartReqOptional.get();
            //如果没有会员价 则使用销售价计算
            BigDecimal memberPrice = goodsPrice.getMemberPrice();
            BigDecimal salePrice = goodsPrice.getSalePrice();
            BigDecimal calculatePriceValue = Objects.nonNull(memberPrice) ? memberPrice : salePrice;
            totalAmount = totalAmount.add(calculatePriceValue.multiply(new BigDecimal(cartReq.getNum())));
        }
        log.info("totalAmount:{}", totalAmount);
        CartCalculateResp resp = CartCalculateResp.builder().totalAmount(AmountUtils.setScaleTwo(totalAmount)).build();
        resp.setPayAmount(totalAmount);
        //如果有打折
        if (Objects.nonNull(member.getDiscount())) {
            resp.setPayAmount(AmountUtils.setScaleTwo(resp.getTotalAmount().multiply(member.getDiscount())));
            resp.setDiscountAmount(resp.getTotalAmount().subtract(resp.getPayAmount()));
        }
        return CommonResult.success(resp);
    }
}