package com.zyx.test;


import com.zyx.entity.mapper.UserMapper;
import com.zyx.entity.model.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.List;

/**
 * mybatis 测试
 * @author zhengyongxian
 * @date 2020/4/1 22:26
 */
public class MybatisTest {
    public static void main(String[] args) throws Exception{
        //1.读取配置文件
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");

        //2.创建 SqlSessionFactory 的构建者对象
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();

        //3.使用构建者创建工厂对象 SqlSessionFactory
        SqlSessionFactory factory = builder.build(in);

        //4.使用 SqlSessionFactory 生产 SqlSession 对象
        SqlSession session = factory.openSession();

        //5.使用 SqlSession 创建 mapper 接口的代理对象
        UserMapper userMapper = session.getMapper(UserMapper.class);

        //6.使用代理对象执行查询所有方法
        List<User> users = userMapper.findAll();
        for (User user : users) {
            System.out.println(user);
        }
        //7.释放资源
        session.close();
        in.close();
    }
}
