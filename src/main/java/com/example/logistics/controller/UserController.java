package com.example.logistics.controller;

import com.example.logistics.common.CommonResponse;
import com.example.logistics.common.CommonResult;
import com.example.logistics.domain.req.LoginOutReq;
import com.example.logistics.domain.req.LoginReq;
import com.example.logistics.domain.req.RegisterReq;
import com.example.logistics.domain.req.UpdateReq;
import com.example.logistics.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author hexiaobo
 * @title: LoginController
 * @projectName jdk
 * @description: TODO
 * @date 2019/4/1916:31
 */
@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 注册
     *
     * @param registerReq
     * @return
     */
    @PostMapping("/register")
    public CommonResponse register(@RequestBody RegisterReq registerReq) {
        CommonResult commonResult = userService.register(registerReq);
        return CommonResponse.common(commonResult.getCode(), commonResult.getMessage(), commonResult.getData());
    }

    /**
     * 登陆
     *
     * @param loginReq
     * @return
     */
    @PostMapping("/login")
    public CommonResponse login(@RequestBody LoginReq loginReq) {
        CommonResult commonResult = userService.login(loginReq);
        return CommonResponse.common(commonResult.getCode(), commonResult.getMessage(), commonResult.getData());
    }

    /**
     * 登出
     *
     * @param loginOutReq
     * @return
     */
    @PostMapping("/loginOut")
    public CommonResponse loginOut(@RequestBody LoginOutReq loginOutReq) {
        CommonResult commonResult = userService.loginOut(loginOutReq);
        return CommonResponse.common(commonResult.getCode(), commonResult.getMessage(), commonResult.getData());
    }

    /**
     * 更新用户
     *
     * @param updateReq
     * @return
     */
    @PostMapping("/updateUser")
    public CommonResponse updateUser(@RequestBody UpdateReq updateReq) {
        CommonResult commonResult = userService.updateUser(updateReq);
        return CommonResponse.common(commonResult.getCode(), commonResult.getMessage(), commonResult.getData());
    }

    /**
     * 找回密码
     *
     * @param updateReq
     * @return
     */
    @PostMapping("/找回密码")
    public CommonResponse findPassword(@RequestBody UpdateReq updateReq) {
        CommonResult commonResult = userService.updateUser(updateReq);
        return CommonResponse.common(commonResult.getCode(), commonResult.getMessage(), commonResult.getData());
    }

}