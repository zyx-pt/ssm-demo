package com.zyx.test;


import com.zyx.entity.mapper.AccountMapper;
import com.zyx.entity.mapper.UserMapper;
import com.zyx.entity.model.Account;
import com.zyx.entity.model.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.management.relation.Role;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

/**
 * mybatis 测试
 * @author zhengyongxian
 * @date 2020/4/1 22:26
 */
public class MybatisTest {

    private InputStream inputStream;
    private SqlSession sqlSession;
    private UserMapper userMapper;
    private AccountMapper accountMapper;


    @Before//用于在测试方法执行之前执行
    public void init() throws IOException {
        // 1.读取配置文件，生成字节输入流
        inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        // 2.获取SqlSessionFactory
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
        // 3.获取SqlSession对象
        sqlSession = factory.openSession();
        // 4.获取的代理对象
        userMapper = sqlSession.getMapper(UserMapper.class);
        accountMapper = sqlSession.getMapper(AccountMapper.class);
    }

    @After//用于在测试方法执行之后执行
    public void destroy() throws IOException {
        sqlSession.commit();
        sqlSession.close();
        inputStream.close();
    }

    @Test
    public void testSave(){
        User user = new User();
        user.setUserName("mybatis annotation");
        user.setUserAddress("北京市昌平区");

        userMapper.saveUser(user);
    }

    @Test
    public void testUpdate(){
        User user = new User();
        user.setUserId(51);
        user.setUserName("mybatis annotation update");
        user.setUserAddress("北京市海淀区");
        user.setUserSex("男");
        user.setUserBirthday(new Date());

        userMapper.updateUser(user);
    }


    @Test
    public void testDelete(){
        userMapper.deleteUser(50);
    }

    @Test
    public void testFindById(){
        User user = userMapper.findById(46);
        System.out.println(user);
        System.out.println(user.getAccounts());
    }


    @Test
    public  void testFindByName(){
//        List<User> users = userMapper.findUserByName("%mybatis%");
        List<User> users = userMapper.findUserByName("%王%");
        for(User user : users){
            System.out.println(user);
            System.out.println(user.getAccounts());
        }
    }

    @Test
    public  void testFindTotal(){
        int total = userMapper.findTotalUser();
        System.out.println(total);
    }

    @Test
    public  void testFindAllUserToAccount(){
        List<User> users = userMapper.findAllUserToAccount();
        for(User user : users){
            System.out.println(user);
            System.out.println(user.getAccounts());
        }
    }

    @Test
    public  void testFindAllAccountToUser(){
        List<Account> accounts = accountMapper.findAllAccountToUser();
        for(Account account : accounts){
            System.out.println(account);
            System.out.println(account.getUser());
        }
    }

}
