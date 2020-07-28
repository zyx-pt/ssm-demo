package com.zyx.service.impl;

import com.zyx.dao.AccountDao;
import com.zyx.entity.model.Account;
import com.zyx.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author zhengyongxian
 * @Date 2020/5/25
 */

public class AccountServiceImpl3 implements AccountService {

    private AccountDao accountDao3;

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao3 = accountDao;
    }

    @Override
    public List<Account> findAllAccount() {
        return accountDao3.findAllAccount();
    }

    @Override
    public Account findAccountById(Integer accountId) {
        return accountDao3.findAccountById(accountId);
    }

    @Override
    public void saveAccount(Account account) {
        accountDao3.saveAccount(account);
    }

    @Override
    public void updateAccount(Account account) {
        accountDao3.updateAccount(account);
    }

    @Override
    public void deleteAccount(Integer acccountId) {
        accountDao3.deleteAccount(acccountId);
    }
}
