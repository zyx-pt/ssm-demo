package com.zyx.dao;

import com.zyx.entity.model.Account;

/**
 * @Description: 账户的持久层接口
 *
 * @Author: zhengyongxian
 * @Date: 2020/7/27 22:06
 */
public interface AccountDao {

    /**
     * @Description: 根据id查询账户信息
     *
     * @Author: zhengyongxian
     * @Date: 2020/7/27 22:04
     * @param accountId
     * @return: com.zyx.entity.model.Account
     */
    Account findAccountById(Integer accountId);


    /**
     * @Description: 根据名称查询账户信息
     *
     * @Author: zhengyongxian
     * @Date: 2020/7/27 22:04
     * @param accountName
     * @return: com.zyx.entity.model.Account
     */
    Account findAccountByName(String accountName);

    /**
     * @Description: 更新账户
     *
     * @Author: zhengyongxian
     * @Date: 2020/7/27 22:08
     * @param account
     * @return: void
     */
    void updateAccount(Account account);
}
