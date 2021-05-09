package com.example.logistics.service;

import com.example.logistics.common.CommonResult;
import com.example.logistics.domain.req.LoginOutReq;
import com.example.logistics.domain.req.LoginReq;
import com.example.logistics.domain.req.RegisterReq;
import com.example.logistics.domain.req.UpdateReq;

/**
 * @author hexiaobo
 * @title: UserService
 * @projectName jdk
 * @description: TODO
 * @date 2019/4/1917:01
 */
public interface    UserService {

    /**
     * 注册
     * @param registerReq
     * @return
     */
    CommonResult register(RegisterReq registerReq);

    /**
     *登录
      * @param loginReq
     * @return
     */
    CommonResult login(LoginReq loginReq);

    /**
     * 登出
     * @param loginOutReq
     * @return
     */
    CommonResult loginOut(LoginOutReq loginOutReq);

    /**
     *更新用户
     * @param updateReq
     * @return
     */
    CommonResult updateUser(UpdateReq updateReq);
}
