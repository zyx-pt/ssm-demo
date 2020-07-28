package com.zyx.mybatis.sqlsession.defaults;

import com.zyx.mybatis.config.Configuration;
import com.zyx.mybatis.sqlsession.SqlSession;
import com.zyx.mybatis.sqlsession.SqlSessionFactory;

/**
 *
 * @Author zhengyongxian
 * @Date 2020/5/9
 */
public class DefaultSqlSessionFactory implements SqlSessionFactory {

    private Configuration configuration;

    public DefaultSqlSessionFactory(Configuration configuration) {
        this.configuration = configuration;
    }

    public SqlSession openSession() {
        return new DefaultSqlSession(configuration);
    }
}
