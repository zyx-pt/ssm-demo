package com.zyx.entity.mapper;

import com.zyx.entity.model.User;

import java.util.List;

/**
 * 用户持久层接口
 * @author zhengyongxian
 * @date 2020/4/1 22:18
 */
public interface UserMapper {

    /**
     * 查询所有
     * @return
     */
    List<User> findAll();
}
