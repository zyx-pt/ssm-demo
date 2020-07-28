package com.zyx.service.impl;

import com.zyx.dao.AccountDao;
import com.zyx.entity.model.Account;
import com.zyx.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description: 用与使用注解的
 * @Author zhengyongxian
 * @Date 2020/7/23 21:06
 */
@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDao accountDao2;

    @Override
    public List<Account> findAllAccount() {
        return accountDao2.findAllAccount();
    }

    @Override
    public Account findAccountById(Integer accountId) {
        return accountDao2.findAccountById(accountId);
    }

    @Override
    public void saveAccount(Account account) {
        accountDao2.saveAccount(account);
    }

    @Override
    public void updateAccount(Account account) {
        accountDao2.updateAccount(account);
    }
    @Override
    public void deleteAccount(Integer accountId) {
        accountDao2.deleteAccount(accountId);
    }

    @Override
    public Account findAccountByName(String name) {
        return accountDao2.findAccountByName(name);
    }

    @Override
    public void transfer(String sourceName, String targetName, Float money) {
        System.out.println("transfer....");
        Account source = accountDao2.findAccountByName(sourceName);
        Account target = accountDao2.findAccountByName(targetName);

        source.setMoney(source.getMoney() - money);
        target.setMoney(target.getMoney() + money);

        accountDao2.updateAccount(source);

        int i = 1/0;

        accountDao2.updateAccount(target);
    }
}
