package com.zyx.dao;

import com.zyx.entity.User;

import java.util.List;

/**
 * 用户持久层接口
 * @author zhengyongxian
 * @date 2020/4/1 22:18
 */
public interface IUserDao {

    /**
     * 查询所有
     * @return
     */
    List<User> findAll();
}
