package com.zyx.service.impl;


import com.zyx.dao.AccountDao;
import com.zyx.entity.model.Account;
import com.zyx.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Description: 用于使用注解的账户的业务层实现类
 * @Author zhengyongxian
 * @Date 2020/7/27 22:02
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)//只读型事务的配置
public class AccountServiceImpl implements AccountService {

    @Autowired

    private AccountDao accountDao2;

    @Override
    public Account findAccountById(Integer accountId) {
        return accountDao2.findAccountById(accountId);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void transfer(String sourceName, String targetName, Float money) {
        System.out.println("transfer....");
        //2.1根据名称查询转出账户
        Account source = accountDao2.findAccountByName(sourceName);
        //2.2根据名称查询转入账户
        Account target = accountDao2.findAccountByName(targetName);
        //2.3转出账户减钱
        source.setMoney(source.getMoney()-money);
        //2.4转入账户加钱
        target.setMoney(target.getMoney()+money);
        //2.5更新转出账户
        accountDao2.updateAccount(source);

        int i=1/0;

        //2.6更新转入账户
        accountDao2.updateAccount(target);
    }
}
