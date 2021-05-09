package com.example.logistics.service;

import com.example.logistics.domain.bean.UserToken;

/**
 * @author hexiaobo
 * @title: UserTokenService
 * @projectName jdk
 * @description: TODO
 * @date 2019/4/2016:27
 */
public interface UserTokenService {
    /**
     *新增token
     * @param userToken
     */
    void addToken(UserToken userToken);

    /**
     * 查询token
     * @param token
     * @return
     */
    UserToken queryTokenInfo(String token);

}