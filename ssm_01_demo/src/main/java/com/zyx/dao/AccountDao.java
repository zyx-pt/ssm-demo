package com.zyx.dao;

import com.zyx.domain.Account;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Description: 账户持久层接口
 *
 * @Author: zhengyongxina
 * @Date: 2020/9/30 9:38
 */
public interface AccountDao {
    /**
     * 保存
     * @param account
     */
    void save(Account account);
    /**
     * 查询所有
     * @return
     */
//    @Select("select * from account")
    List<Account> findAll();
}
