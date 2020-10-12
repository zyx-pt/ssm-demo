package com.zyx.service.impl;

import com.zyx.dao.AccountDao;
import com.zyx.domain.Account;
import com.zyx.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description: 账户业务层接口实现类
 *
 * @Author: zhengyongxina
 * @Date: 2020/9/30 9:38
 */
@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDao accountDao;

    @Override
    public void saveAccount(Account account) {
        accountDao.save(account);
    }

    @Override
    public List<Account> findAllAccount() {
        System.out.println("业务层：查询所有账户...");
        return accountDao.findAll();
    }
}
