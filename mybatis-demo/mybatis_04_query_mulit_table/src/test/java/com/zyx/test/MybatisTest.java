package com.zyx.test;


import com.zyx.entity.mapper.AccountMapper;
import com.zyx.entity.mapper.RoleMapper;
import com.zyx.entity.mapper.UserMapper;
import com.zyx.entity.model.Account;
import com.zyx.entity.model.AccountUser;
import com.zyx.entity.model.Role;
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
    private SqlSession sqlSession;
    private UserMapper userMapper;
    private AccountMapper accountMapper;
    private RoleMapper roleMapper;


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
        roleMapper = sqlSession.getMapper(RoleMapper.class);
    }

    @After//用于在测试方法执行之后执行
    public void destroy() throws IOException {
        sqlSession.commit();
        sqlSession.close();
        inputStream.close();
    }

    /**
     * 测试查询所有账户，同时包含用户名称和地址   --> 一对一
     */
    @Test
    public void testFindAllAccountToUser(){
        List<AccountUser> aus = accountMapper.findAllAccount();
        for(AccountUser au : aus){
            System.out.println("--------每个  账户+用户名称和地址 的信息------------");
            System.out.println(au);
        }
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
    public  void testFindAllUserToAccount(){
        List<User> users = userMapper.findAllUserToAccount();
        for (User user : users) {
            System.out.println("-----每个  用户+账户  的信息------");
            System.out.println(user);
            System.out.println(user.getAccounts());
        }
    }

    /**
     * 测试根据id查询用户信息 --> 一对多
     */
    @Test
    public  void testFindById(){
        User user = userMapper.findById(46);
        System.out.println("-----Id46  用户+账户   的信息------");
        System.out.println(user);
        System.out.println(user.getAccounts());
    }

    /**
     * 测试所有 账户+角色  --> 多对多
     */
    @Test
    public void testFindAllUserToRole(){
        List<User> users = userMapper.findAllUserToRole();
        for(User user : users){
            System.out.println("-----每个  账户+角色    的信息------");
            System.out.println(user);
            System.out.println(user.getRoles());
        }
    }

    /**
     * 测试查询所有角色+账户  --> 多对多
     */
    @Test
    public void testFindAll(){
        List<Role> roles = roleMapper.findAll();
        for(Role role : roles){
            System.out.println("---每个  角色+账户    的信息----");
            System.out.println(role);
            System.out.println(role.getUsers());
        }
    }


}
