package com.zyx.service;

import com.zyx.entity.model.Account;

import java.util.List;

/**
 * 账户业务层的接口
 * @Author zhengyongxian
 * @Date 2020/5/25
 */
public interface AccountService {

    /**
     * 查询所有
     * @return
     */
    List<Account> findAllAccount();

    /**
     * 查询一个
     * @return
     */
    Account findAccountById(Integer accountId);

    /**
     * 保存
     * @param account
     */
    void saveAccount(Account account);

    /**
     * 更新
     * @param account
     */
    void updateAccount(Account account);

    /**
     * 删除
     * @param accountId
     */
    void deleteAccount(Integer accountId);
}
