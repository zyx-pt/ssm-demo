package com.zyx.entity.mapper;

import com.zyx.entity.model.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

/**
 * @Author zhengyongxian
 * @Date 2020/5/20
 */
@CacheNamespace(blocking=true)//mybatis 基于注解方式实现配置二级缓存
public interface UserMapper {
    /**
     * 查询所有用户
     * @return
     */
    @Select("select * from user")
    List<User> findAll();

    /**
     * 保存用户
     * @param user
     */
    @Insert("insert into user(username,address,sex,birthday)values(#{userName},#{userAddress},#{userSex},#{userBirthday})")
    void saveUser(User user);

    /**
     * 更新用户
     * @param user
     */
    @Update("update user set username=#{userName},sex=#{userSex},birthday=#{userBirthday},address=#{userAddress} where id=#{userId}")
    void updateUser(User user);

    /**
     * 删除用户
     * @param userId
     */
    @Delete("delete from user where id=#{userId} ")
    void deleteUser(Integer userId);

    /**
     * 根据id查询用户
     * @param userId
     * @return
     */
    @Select("select * from user  where id=#{userId} ")
    @ResultMap("userMap")
    User findById(Integer userId);

    /**
     * 根据用户名称模糊查询
     * @param userName
     * @return
     */
    @Select("select * from user where username like #{userName} ")
//    @Select("select * from user where username like '%${value}%' ")
    @ResultMap("userMap")
    List<User> findUserByName(String userName);

    /**
     * 查询总用户数量
     * @return
     */
    @Select("select count(*) from user ")
    int findTotalUser();

    /**
     * 查询所有用户+对应账户
     * @return
     */
    @Select("select * from user")
    @Results(id="userMap",value={
            @Result(id = true, column = "id",property = "userId"),
            @Result(column = "username",property = "userName"),
            @Result(column = "address",property = "userAddress"),
            @Result(column = "sex",property = "userSex"),
            @Result(column = "birthday",property = "userBirthday"),
            @Result(property = "accounts",column = "id",
                    many = @Many(select = "com.zyx.entity.mapper.AccountMapper.findAccountByUid",
                            fetchType = FetchType.LAZY))
    })
    List<User> findAllUserToAccount();

}
