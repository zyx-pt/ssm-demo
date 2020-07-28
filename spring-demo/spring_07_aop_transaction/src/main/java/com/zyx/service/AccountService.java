package com.zyx.service;

import com.zyx.entity.model.Account;

import java.util.List;


/**
 * @Description:
 * @Author zhengyongxian
 * @Date 2020/7/23 21:04
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
     * @Description: 根据账户名称查找
     *
     * @Author: zhengyongxian
     * @Date: 2020/7/25 17:55
     * @param name
     * @return: com.zyx.entity.model.Account
     */
    Account findAccountByName(String name);

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

    /**
     * @Description: 转账
     *
     * @Author: zhengyongxian
     * @Date: 2020/7/25 17:52
     * @param sourceName 转出账户名称
     * @param targetName 转入账户名称
     * @param money 转账金额
     * @return: void
     */
    void transfer(String sourceName, String targetName, Float money);
}