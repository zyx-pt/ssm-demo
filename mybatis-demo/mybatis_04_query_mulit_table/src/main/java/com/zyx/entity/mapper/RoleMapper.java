package com.zyx.entity.mapper;

import com.zyx.entity.model.Role;

import java.util.List;

/**
 * @Author zhengyongxian
 * @Date 2020/5/20
 */
public interface RoleMapper {

    /**
     * 查询所有角色
     * @return
     */
    List<Role> findAll();
}
