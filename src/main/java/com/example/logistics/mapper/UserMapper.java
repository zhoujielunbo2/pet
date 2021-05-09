package com.example.logistics.mapper;

import com.example.logistics.domain.bean.User;
/**
 * @author hexiaobo
 * @title: UserMapper
 * @description: TODO
 * @date 2019/4/1916:31
 */
public interface UserMapper {
    /**
     * 注册
     * @param user
     */
   void register(User user);

    /**
     * 根据手机号查用户信息
     * @param phone
     * @return
     */
   User queryByPhone(String phone);

    /**
     * 更新用户
     * @param user
     */
   void  updateUser(User user);
}
