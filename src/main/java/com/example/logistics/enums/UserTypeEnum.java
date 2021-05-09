package com.example.logistics.enums;

/**
 * @author hexiaobo
 * @title: UserTypeEnum
 * @projectName logistics
 * @description: TODO
 * @date 2019/4/2021:56
 */
public enum UserTypeEnum {
    /*

     */
    USER(1,"员工"),SHOP_MANAGE(2,"店长"),BOSS(3,"老板");
    private Integer type;
    private String desc;

    UserTypeEnum(Integer type,String desc){
        this.type=type;
        this.desc=desc;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
