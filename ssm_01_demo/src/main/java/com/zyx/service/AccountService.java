package com.zyx.service;

import com.zyx.domain.Account;

import java.util.List;

/**
 * @Description: 账户业务层接口
 *
 * @Author: zhengyongxina
 * @Date: 2020/9/30 9:38
 */
public interface AccountService {
    /**
     * 保存账户
     * @param account
     */
    void saveAccount(Account account);
    /**
     * 查询所有账户
     * @return
     */
    List<Account> findAllAccount();
}
