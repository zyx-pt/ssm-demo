package com.zyx.dao.impl;

import com.zyx.dao.AccountDao;
import org.springframework.stereotype.Repository;

/**
 * @Author zhengyongxian
 * @Date 2020/5/25
 */
@Repository("accountDao1")
public class AccountDaoImpl implements AccountDao {
    public  void saveAccount(){

        System.out.println("保存了账户1111111111111");
    }
}
