package com.zyx.service;

import com.zyx.entity.model.Account;

/**
 * @Description: 账户的业务层接口
 * @Author zhengyongxian
 * @Date 2020/7/27 22:02
 */
public interface AccountService {

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
     * @Description: 转账
     *
     * @Author: zhengyongxian
     * @Date: 2020/7/27 22:05
     * @param sourceName 转出账户名称
     * @param targetName 转入账户名称
     * @param money 转账金额
     * @return: void
     */
    void transfer(String sourceName, String targetName, Float money);

    /**
     * @Description: 用于事务模板的使用
     *
     * @Author: zhengyongxian
     * @Date: 2020/7/28 16:25
     * @param sourceName
     * @param targetName
     * @param money
     * @return: void
     */
    void transfer2(String sourceName, String targetName, Float money);
}
