package com.zyx.test;


import com.zyx.entity.mapper.UserMapper;
import com.zyx.entity.model.User;
import com.zyx.mybatis.io.Resources;
import com.zyx.mybatis.sqlsession.SqlSession;
import com.zyx.mybatis.sqlsession.SqlSessionFactory;
import com.zyx.mybatis.sqlsession.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.List;

/**
 * mybatis 自定义测试
 * @author zhengyongxian
 * @date 2020/4/1 22:26
 */
public class MybatisTest {
    public static void main(String[] args) throws Exception{
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");

        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();

        SqlSessionFactory factory = builder.build(in);

        SqlSession session = factory.openSession();

        UserMapper userDao = session.getMapper(UserMapper.class);

//        List<User> users = userDao.findAll();
        List<User> users = userDao.findAllByAnnotation();

        for (User user : users) {
            System.out.println(user);
        }
        session.close();
        in.close();
    }
}
