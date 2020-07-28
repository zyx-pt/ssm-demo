package com.zyx.dao.impl;

import com.zyx.dao.AccountDao;
import com.zyx.entity.model.Account;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.util.List;

/**
 * Dao中使用JdbcTemplate，通过继承JdbcDaoSupport
 * 测试中暂时不具体添加，只需修改xml中AccountDaoImpl3-->AccountDaoImpl4
 * JdbcDaoSupport只能用于基于 XML 的方式，注解用不了
 * @Author zhengyongxian
 * @Date 2020/7/27 16:25
 */

public class AccountDaoImpl4 extends JdbcDaoSupport implements AccountDao {
    

    @Override
    public List<Account> findAllAccount() {
        try{
            return super.getJdbcTemplate().query("select * from account",new BeanPropertyRowMapper<Account>(Account.class));
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Account findAccountById(Integer accountId) {
        try{
            List<Account> accounts = super.getJdbcTemplate().query("select * from account where id = ? ",new BeanPropertyRowMapper<Account>(Account.class),accountId);
            if (accounts.isEmpty()) {
                return null;
            }
            if (accounts.size() > 1){
                throw new RuntimeException("结果集不唯一");
            }
            return accounts.get(0);
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void saveAccount(Account account) {
        try{
            String sql = "insert into account(name,money)values('"+account.getName()+"','"+account.getMoney()+"')";
            super.getJdbcTemplate().execute(sql);
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateAccount(Account account) {
        try{
            super.getJdbcTemplate().update("update account set name=?,money=? where id=?",account.getName(),account.getMoney(),account.getId());
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteAccount(Integer accountId) {
        try{
            super.getJdbcTemplate().update("delete from account where id=?",accountId);
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
