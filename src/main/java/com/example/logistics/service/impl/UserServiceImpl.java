package com.example.logistics.service.impl;

import com.example.logistics.common.CommonResult;
import com.example.logistics.common.Constant;
import com.example.logistics.domain.bean.Shop;
import com.example.logistics.domain.bean.User;
import com.example.logistics.domain.bean.UserToken;
import com.example.logistics.domain.req.LoginOutReq;
import com.example.logistics.domain.req.LoginReq;
import com.example.logistics.domain.req.RegisterReq;
import com.example.logistics.domain.req.UpdateReq;
import com.example.logistics.domain.resp.LoginResp;
import com.example.logistics.domain.resp.ShopResp;
import com.example.logistics.enums.ResultCode;
import com.example.logistics.mapper.ShopMapper;
import com.example.logistics.mapper.UserMapper;
import com.example.logistics.mapper.UserTokenMapper;
import com.example.logistics.service.UserService;
import com.example.logistics.util.CommonUtils;
import com.example.logistics.util.MD5Utils;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author hexiaobo
 * @title: UserServiceImpl
 * @projectName jdk
 * @description: TODO
 * @date 2019/4/1917:01
 */
@Service
public class UserServiceImpl implements UserService {

    private Lock lock = new ReentrantLock();
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserTokenMapper userTokenMapper;
    @Autowired
    private ShopMapper shopMapper;

    @Override
    public CommonResult register(RegisterReq registerReq) {
        if (StringUtils.isBlank(registerReq.getPhone()) || StringUtils.isBlank(registerReq.getNickName())
                || StringUtils.isBlank(registerReq.getPassword()) || StringUtils.isBlank(registerReq.getConfirmPassword())
                || StringUtils.isBlank(registerReq.getVerifyCode()) || Objects.isNull(registerReq.getType())) {
            return CommonResult.fail(ResultCode.PARA_IS_EMPTY.getCode(), ResultCode.PARA_IS_EMPTY.getMsg());
        }
        if (registerReq.getPhone().length() != Constant.PHONE_LENGTH) {
            return CommonResult.fail(ResultCode.PHONE_IS_VALID.getCode(), ResultCode.PHONE_IS_VALID.getMsg());
        }
        if (!registerReq.getPassword().equals(registerReq.getConfirmPassword())) {
            return CommonResult.fail(ResultCode.PASSPORT_IS_DIFF.getCode(), ResultCode.PASSPORT_IS_DIFF.getMsg());
        }
        trim(registerReq);
        lock.lock();
        try {
            if (Objects.nonNull(userMapper.queryByPhone(registerReq.getPhone()))) {
                return CommonResult.fail(ResultCode.PHONE_IS_EXIST.getCode(), ResultCode.PHONE_IS_EXIST.getMsg());
            }
            User user = new User();
            CommonUtils.convert(user, registerReq);
            user.setCreateTime(new Date());
            user.setPassword(MD5Utils.MD5Encode(user.getPassword()));
            userMapper.register(user);
            return new CommonResult();
        } finally {
            lock.unlock();
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public CommonResult login(LoginReq loginReq) {
        if (StringUtils.isBlank(loginReq.getPhone()) || StringUtils.isBlank(loginReq.getPassword())
                || Objects.isNull(loginReq.getType())) {
            return CommonResult.fail(ResultCode.PARA_IS_EMPTY.getCode(), ResultCode.PARA_IS_EMPTY.getMsg());
        }
        trim(loginReq);
        User user = userMapper.queryByPhone(loginReq.getPhone());
        if (Objects.isNull(user)) {
            return CommonResult.fail(ResultCode.PHONE_IS_NOT_EXIST.getCode(), ResultCode.PHONE_IS_NOT_EXIST.getMsg());
        }
        String md5Passport = MD5Utils.MD5Encode(loginReq.getPassword());
        if (!user.getPassword().equals(md5Passport)) {
            return CommonResult.fail(ResultCode.PASSPORT_ERROR.getCode(), ResultCode.PASSPORT_ERROR.getMsg());
        }
        String token = UUID.randomUUID().toString().replace("-", "");
        LoginResp resp = new LoginResp();
        resp.setHeadPic(user.getHeadPic());
        resp.setToken(token);
        UserToken userToken = new UserToken();
        userToken.setToken(token);
        userToken.setPhone(loginReq.getPhone());
        userToken.setType(loginReq.getType());
        userTokenMapper.deleteTokenByPhone(loginReq.getPhone(), loginReq.getType());
        userTokenMapper.addToken(userToken);
        List<Shop> shopList = shopMapper.queryShopListByPhone(user.getPhone());
        if (CollectionUtils.isNotEmpty(shopList)) {
            List<ShopResp> shopRespList = resp.getShopRespList();
            ShopResp shopResp;
            for (Shop shop : shopList) {
                shopResp = new ShopResp();
                CommonUtils.convert(shopResp, shop);
                shopResp.setCloseVIP(shop.getIsCloseVIP()==1);
                shopRespList.add(shopResp);
            }
        }
        return new CommonResult(resp);
    }

    @Override
    public CommonResult loginOut(LoginOutReq loginOutReq) {
        if (StringUtils.isBlank(loginOutReq.getToken())) {
            return CommonResult.fail(ResultCode.PARA_IS_EMPTY.getCode(), ResultCode.PARA_IS_EMPTY.getMsg());
        }
        loginOutReq.setToken(StringUtils.trim(loginOutReq.getToken()));
        userTokenMapper.deleteByToken(loginOutReq.getToken());
        return new CommonResult();
    }

    @Override
    public CommonResult updateUser(UpdateReq updateReq) {
        if (StringUtils.isBlank(updateReq.getToken()) || Objects.isNull(userTokenMapper.queryByToken(updateReq.getToken().trim()))) {
            return CommonResult.fail(ResultCode.NO_LOGIN.getCode(), ResultCode.NO_LOGIN.getMsg());
        }
        if (StringUtils.isBlank(updateReq.getPhone())) {
            return CommonResult.fail(ResultCode.PHONE_IS_NOT_NULL.getCode(), ResultCode.PHONE_IS_NOT_NULL.getMsg());
        }
        trim(updateReq);
        if (Objects.isNull(userMapper.queryByPhone(updateReq.getPhone()))) {
            return CommonResult.fail(ResultCode.PHONE_IS_NOT_EXIST.getCode(), ResultCode.PHONE_IS_NOT_EXIST.getMsg());
        }
        User user = new User();
        CommonUtils.convert(user, updateReq);
        user.setPassword(MD5Utils.MD5Encode(user.getPassword()));
        userMapper.updateUser(user);
        return new CommonResult();
    }

    private void trim(LoginReq req) {
        req.setPassword(StringUtils.trim(req.getPassword()));
        req.setPhone(StringUtils.trim(req.getPhone()));
    }

    private void trim(RegisterReq req) {
        req.setVerifyCode(StringUtils.trim(req.getVerifyCode()));
        req.setPassword(StringUtils.trim(req.getPassword()));
        req.setConfirmPassword(StringUtils.trim(req.getConfirmPassword()));
        req.setNickName(StringUtils.trim(req.getNickName()));
        req.setPhone(StringUtils.trim(req.getPhone()));
    }

    private void trim(UpdateReq req) {
        req.setPassword(StringUtils.trim(req.getPassword()));
        req.setNickName(StringUtils.trim(req.getNickName()));
        req.setPhone(StringUtils.trim(req.getPhone()));
        req.setToken(StringUtils.trim(req.getToken()));
    }
}