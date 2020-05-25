package com.zyx.dao.impl;

import com.zyx.dao.AccountDao;
import org.springframework.stereotype.Repository;

/**
 * 账户的持久层实现类
 * @Author zhengyongxian
 * @Date 2020/5/25
 */
@Repository("accountDao2")
public class AccountDaoImpl2 implements AccountDao {

    public  void saveAccount(){

        System.out.println("保存了账户2222222222222");
    }
}
