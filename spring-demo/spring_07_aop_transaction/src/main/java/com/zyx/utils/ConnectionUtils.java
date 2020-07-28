package com.zyx.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;

/**
 * @Description: 连接的工具类，它用于从数据源中获取一个连接，并且实现和线程的绑定
 * @Author zhengyongxian
 * @Date 2020/7/24 16:47
 */
@Component
public class ConnectionUtils {

    public ThreadLocal<Connection> threadLocal = new ThreadLocal<Connection>();
    @Autowired
    private DataSource dataSource;

    /**
     * @Description: 获取当前线程的连接
     *
     * @Author: zhengyongxian
     * @Date: 2020/7/24 16:59
     * @param
     * @return: java.sql.Connection
     */
    public Connection getThreadConnection(){
        try {
            Connection connection = threadLocal.get();
            if (connection == null) {
                connection = dataSource.getConnection();
                threadLocal.set(connection);
            }
            return connection;
        }catch (Exception e){
            throw new RuntimeException(e);
        }

    }

    /**
     * @Description: 将连接和线程解绑
     *
     * @Author: zhengyongxian
     * @Date: 2020/7/24 16:59
     * @param
     * @return: void
     */
    public void removeConnection(){
        threadLocal.remove();
    }
}
