package com.example.logistics.mapper;


import com.example.logistics.domain.bean.UserToken;
import org.apache.ibatis.annotations.Param;

/**
 * @author hexiaobo
 * @title: UserTokenMapper
 * @projectName jdk
 * @description: TODO
 * @date 2019/4/1916:31
 */
public interface UserTokenMapper {
    /**
     * 新增token
     * @param userToken
     */
    void addToken(UserToken userToken);

    /**
     * 根据手机号删除token
     * @param phone
     * @param type
     */
    void  deleteTokenByPhone(@Param("phone") String phone,@Param("type") Integer type);

    /**
     * 根据token删除
     * @param token
     */
    void  deleteByToken(String token);

    /**
     * 根据token查询
     * @param token
     * @return
     */
    UserToken queryByToken(String token);


}
