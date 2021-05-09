package com.example.logistics.enums;

/**
 * @author hexiaobo
 * @title: OrderStatusEnum
 * @projectName logistics
 * @date 2019/4/2021:56
 */
public enum OrderStatusEnum {
    /**
     *
     */
    ALREADY_PAY(1,"已付款"),ALREADY_RETURN(2,"已退款");
    private Integer status;
    private String desc;

    OrderStatusEnum(Integer status, String desc){
        this.status=status;
        this.desc=desc;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
