package com.zyx.entity.mapper;

import com.zyx.entity.model.Account;

import java.util.List;

/**
 * @Author zhengyongxian
 * @Date 2020/5/20
 */
public interface AccountMapper {

    /**
     * 查询所有账户，同时还要获取到当前账户的所属用户信息
     * @return
     */
    List<Account> findAll();

    /**
     * 根据用户 id 查询账户信息
     * @param uid
     * @return
     */
    List<Account> findByUid(Integer uid);

}
