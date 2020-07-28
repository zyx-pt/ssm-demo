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

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * mybatis 测试
 * @author zhengyongxian
 * @date 2020/4/1 22:26
 */
public class MybatisTest {

    private InputStream inputStream;
    private SqlSessionFactory factory;
    private SqlSession sqlSession;
    private UserMapper userMapper;
    private AccountMapper accountMapper;


    @Before//用于在测试方法执行之前执行
    public void init() throws IOException {
        // 1.读取配置文件，生成字节输入流
        inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        // 2.获取SqlSessionFactory
        factory = new SqlSessionFactoryBuilder().build(inputStream);
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

    /**
     * 测试查询所有 账户+用户 --> 一对一
     */
    @Test
    public void testFindAllAccount(){
        List<Account> accounts = accountMapper.findAll();
        for(Account account : accounts){
            System.out.println("--------每个  账户+用户  的信息------------");
            System.out.println(account);
            System.out.println(account.getUser());
        }
    }

    /**
     * 测试查询所有  用户+账户  --> 一对多
     */
    @Test
    public void testFindAllUserToAccount(){
        List<User> users = userMapper.findAllUserToAccount();
        System.out.println(users.get(0).getUsername());
        System.out.println(users.get(0).getAccounts());
    }

    @Test
    public void testFirstLevelCache(){
        User user1 = userMapper.findById(41);
        System.out.println(user1);
//        sqlSession.clearCache();//此方法也可以清空缓存

        User user2 = userMapper.findById(41);
        System.out.println(user2);

        System.out.println(user1 == user2);
    }

    @Test
    public void testSecondLevelCache(){
        SqlSession sqlSession1 = factory.openSession();
        UserMapper userMapper1 = sqlSession1.getMapper(UserMapper.class);
        User user1 = userMapper1.findById(41);
        System.out.println(user1);
        sqlSession1.close();//一级缓存消失

        SqlSession sqlSession2 = factory.openSession();
        UserMapper userMapper2 = sqlSession2.getMapper(UserMapper.class);
        User user2 = userMapper2.findById(41);
        System.out.println(user2);
        sqlSession2.close();

        System.out.println(user1 == user2);
    }
}
