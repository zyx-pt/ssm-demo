package com.zyx.dao.impl;

import com.zyx.dao.AccountDao;

/**
 * 账户的持久层实现类
 * @Author zhengyongxian
 * @Date 2020/5/25
 */
public class AccountDaoImpl implements AccountDao {

    public  void saveAccount(){
        System.out.println("保存了账户");
    }
}
