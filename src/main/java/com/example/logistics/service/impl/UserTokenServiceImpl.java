package com.example.logistics.service.impl;

import com.example.logistics.domain.bean.UserToken;
import com.example.logistics.mapper.UserTokenMapper;
import com.example.logistics.service.UserTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author hexiaobo
 * @title: UserTokenServiceImpl
 * @projectName jdk
 * @description: TODO
 * @date 2019/4/2016:29
 */
@Service
public class UserTokenServiceImpl implements UserTokenService {

    @Autowired
    private UserTokenMapper userTokenMapper;
    @Override
    public void addToken(UserToken userToken) {
        userTokenMapper.addToken(userToken);
    }

    @Override
    public UserToken queryTokenInfo(String token) {
        return userTokenMapper.queryByToken(token);
    }
}