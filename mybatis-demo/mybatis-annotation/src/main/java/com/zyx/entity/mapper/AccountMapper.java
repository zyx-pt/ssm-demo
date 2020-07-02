package com.zyx.entity.mapper;

import com.zyx.entity.model.Account;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

/**
 * @Author zhengyongxian
 * @Date 2020/5/20
 */
public interface AccountMapper {

    /**
     * 查询所有账户
     * @return
     */
    @Select("select * from account")
    List<Account> findAll();

    /**
     * 查询所有账户，并且获取每个账户所属的用户信息
     * @return
     */
    @Select("select * from account")
    @Results(id="accountMap",value = {
            @Result(id=true,column = "id",property = "id"),
            @Result(column = "uid",property = "uid"),
            @Result(column = "money",property = "money"),
            @Result(property = "user",column = "uid",
                    one=@One(select="com.zyx.entity.mapper.UserMapper.findById",fetchType= FetchType.EAGER))
    })
    List<Account> findAllAccountToUser();

    /**
     * 根据用户id查询账户信息
     * @param userId
     * @return
     */
    @Select("select * from account where uid = #{userId}")
    List<Account> findAccountByUid(Integer userId);
}