package com.zyx.entity.mybatis.sqlsession.defaults;

import com.zyx.entity.mybatis.config.Configuration;
import com.zyx.entity.mybatis.proxy.MapperProxy;
import com.zyx.entity.mybatis.sqlsession.SqlSession;
import com.zyx.entity.mybatis.utils.DataSourceUtil;

import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @Author zhengyongxian
 * @Date 2020/5/9
 */
public class DefaultSqlSession implements SqlSession {

    private Configuration configuration;
    private Connection connection;

    public DefaultSqlSession(Configuration configuration) {
        this.configuration = configuration;
        connection = DataSourceUtil.getConnection(configuration);
    }

    /**
     * 用于创建代理对象
     * @param daoInterfaceClass dao的接口字节码
     * @param <T>
     * @return
     */
    public <T> T getMapper(Class<T> daoInterfaceClass) {
        return (T) Proxy.newProxyInstance(daoInterfaceClass.getClassLoader(),
                new Class[]{daoInterfaceClass}, new MapperProxy(configuration.getMappers(), connection));
    }

    /**
     * 释放资源
     */
    public void close() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
}
