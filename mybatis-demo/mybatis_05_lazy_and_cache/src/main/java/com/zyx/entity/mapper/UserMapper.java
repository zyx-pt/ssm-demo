package com.zyx.entity.mapper;

import com.zyx.entity.model.User;

import java.util.List;

/**
 * @Author zhengyongxian
 * @Date 2020/5/20
 */
public interface UserMapper {
    /**
     * 查询所有用户，同时获取到用户下所有账户的信息
     * @return
     */
    List<User> findAllUserToAccount();


    /**
     * 根据id查询用户信息
     * @param userId
     * @return
     */
    User findById(Integer userId);

}
