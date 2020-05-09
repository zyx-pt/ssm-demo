package com.zyx.entity.mybatis.sqlsession;

import com.zyx.entity.mybatis.config.Configuration;
import com.zyx.entity.mybatis.sqlsession.defaults.DefaultSqlSessionFactory;
import com.zyx.entity.mybatis.utils.XMLConfigBuilder;

import java.io.InputStream;

/**
 * 用于创建一个SqlSessionFactory对象
 * @Author zhengyongxian
 * @Date 2020/5/9
 */
public class SqlSessionFactoryBuilder {

    /**
     * 根据参数的字节输入流来构建一个SqlSessionFactory工厂
     * @param config
     * @return
     */
    public SqlSessionFactory build(InputStream config){
        Configuration cfg = XMLConfigBuilder.loadConfiguration(config);
        return  new DefaultSqlSessionFactory(cfg);
    }
}
