package com.zyx.service;

/**
 * 账户业务层的接口
 */
public interface AccountService {

    /**
     * 模拟保存账户
     */
    void saveAccount();

    /**
     * 模拟更新账户
     * @param i
     */
    void updateAccount(int i);

    void updateOther();

    /**
     * 删除账户
     * @return
     */
    int  deleteAccount();
}
