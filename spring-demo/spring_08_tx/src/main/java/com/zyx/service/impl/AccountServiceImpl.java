package com.zyx.service.impl;

import com.zyx.dao.AccountDao;
import com.zyx.entity.model.Account;
import com.zyx.service.AccountService;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

/**
 * @Description: 用于使用xml账户的业务层实现类
 * @Author zhengyongxian
 * @Date 2020/7/27 22:02
 */
public class AccountServiceImpl implements AccountService {

    private AccountDao accountDao;

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    private TransactionTemplate transactionTemplate;

    public void setTransactionTemplate(TransactionTemplate transactionTemplate) {
        this.transactionTemplate = transactionTemplate;
    }

    @Override
    public Account findAccountById(Integer accountId) {
        return accountDao.findAccountById(accountId);
    }

    /**
     * @Description: 用于xml配置事务
     *
     * @Author: zhengyongxian
     * @Date: 2020/7/28 16:24
     * @param sourceName
     * @param targetName
     * @param money
     * @return: void
     */
    @Override
    public void transfer(String sourceName, String targetName, Float money) {
        doTransfer(sourceName, targetName, money);
    }

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
    @Override
    public void transfer2(final String sourceName, final String targetName, final Float money) {
        transactionTemplate.execute(new TransactionCallback<Object>() {
            @Override
            public Object doInTransaction(TransactionStatus transactionStatus) {
                doTransfer(sourceName, targetName, money);
                return null;
            }
        });
    }

    private void doTransfer(String sourceName, String targetName, Float money) {
        System.out.println("transfer....");
        //2.1根据名称查询转出账户
        Account source = accountDao.findAccountByName(sourceName);
        //2.2根据名称查询转入账户
        Account target = accountDao.findAccountByName(targetName);
        //2.3转出账户减钱
        source.setMoney(source.getMoney() - money);
        //2.4转入账户加钱
        target.setMoney(target.getMoney() + money);
        //2.5更新转出账户
        accountDao.updateAccount(source);

        int i = 1 / 0;

        //2.6更新转入账户
        accountDao.updateAccount(target);
    }

}
