package com.example.logistics.common;

import com.example.logistics.enums.ResultCode;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author hexiaobo
 * @title: CommonResult
 * @description: TODO
 * @date 2019/3/20 11:37
 */
@Data
public class CommonResult<T> {
    private String code= ResultCode.SUCCESS.getCode();
    private String message= ResultCode.SUCCESS.getMsg();
    private T data;
    public CommonResult(){
    }
    public CommonResult(T data){
        this.data=data;
    }
    public CommonResult(String code,String message){
        this.code=code;
        this.message=message;
    }

    public CommonResult(String code,String message,T data){
        this.code=code;
        this.message=message;
        this.data=data;
    }

    public static <T> CommonResult common(String code,String message,T data){
        return  new CommonResult(code,message,data);
    }


    public static <T> CommonResult success(T data){
        return  new CommonResult(ResultCode.SUCCESS.getCode(),ResultCode.SUCCESS.getMsg(),data);
    }

    public static <T> CommonResult success(){
        return  new CommonResult(ResultCode.SUCCESS.getCode(),ResultCode.SUCCESS.getMsg());
    }

    public static CommonResult fail(String code,String message){
        return  new CommonResult(code,message);
    }
}