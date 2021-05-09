package com.example.logistics.util;
import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @author hexiaobo
 * @title: AmountUtils
 * @projectName logistics
 * @description: AmountUtils
 * @date 2019/5/12 19:04
 */
public class AmountUtils {
    /**
     * 保留两位小数
     * @param amount
     * @return
     */
    public static BigDecimal setScaleTwo(BigDecimal amount){
        return  amount.setScale(2, RoundingMode.HALF_UP);
    }

    public static void main(String[] args) {
        BigDecimal s=new BigDecimal("23455.22");
        System.out.println(setScaleTwo(s));
    }
}