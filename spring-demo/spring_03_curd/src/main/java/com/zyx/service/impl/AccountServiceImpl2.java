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
@Service("accountService2")
public class AccountServiceImpl2 implements AccountService {

    @Autowired
    private AccountDao accountDao2;


    public void setAccountDao(AccountDao accountDao2) {
        this.accountDao2 = accountDao2;
    }

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
    public void deleteAccount(Integer acccountId) {
        accountDao2.deleteAccount(acccountId);
    }
}
