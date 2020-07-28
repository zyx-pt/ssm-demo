package com.zyx.dao.impl;

import com.zyx.dao.AccountDao;
import com.zyx.entity.model.Account;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Dao中使用JdbcTemplate
 * @Author zhengyongxian
 * @Date 2020/7/27 16:25
 */

public class AccountDaoImpl3 implements AccountDao {

    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Account> findAllAccount() {
        try{
            return jdbcTemplate.query("select * from account",new BeanPropertyRowMapper<Account>(Account.class));
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Account findAccountById(Integer accountId) {
        try{
            List<Account> accounts = jdbcTemplate.query("select * from account where id = ? ",new BeanPropertyRowMapper<Account>(Account.class),accountId);
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
            jdbcTemplate.execute(sql);
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateAccount(Account account) {
        try{
            jdbcTemplate.update("update account set name=?,money=? where id=?",account.getName(),account.getMoney(),account.getId());
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteAccount(Integer accountId) {
        try{
            jdbcTemplate.update("delete from account where id=?",accountId);
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
