package com.example.logistics.common;

import com.example.logistics.enums.ResultCode;
import lombok.Data;

/**
 * @author hexiaobo
 * @title: CommonResponse
 * @projectName jdk
 * @description: TODO
 * @date 2019/4/1916:45
 */
@Data
public class CommonResponse<T> {
    String code = ResultCode.SUCCESS.getCode();
    String message=ResultCode.SUCCESS.getMsg();
    private T data;

    public CommonResponse(){
    }
    public CommonResponse(String code,String message){
        this.code=code;
        this.message=message;
    }

    public CommonResponse(String code,String message,T data){
        this.code=code;
        this.message=message;
        this.data=data;
    }

    public static <T> CommonResponse common(String code,String message,T data){
        return  new CommonResponse(code,message,data);
    }


    public static <T> CommonResponse success(T data){
        return  new CommonResponse(ResultCode.SUCCESS.getCode(),ResultCode.SUCCESS.getMsg(),data);
    }

    public static CommonResponse fail(String code,String message){
        return  new CommonResponse(code,message);
    }
}