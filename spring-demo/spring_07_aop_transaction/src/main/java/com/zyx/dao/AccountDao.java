package com.zyx.dao;

import com.zyx.entity.model.Account;

import java.util.List;

/**
 * @Description:
 * @Author zhengyongxian
 * @Date 2020/7/23 21:04
 */
public interface AccountDao {

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

    Account findAccountByName(String name);
}