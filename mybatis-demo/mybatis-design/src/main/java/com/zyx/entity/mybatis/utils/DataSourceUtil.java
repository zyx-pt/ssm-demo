package com.zyx.entity.mybatis.utils;


import com.zyx.entity.mybatis.config.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;


/**
 * 用于创建数据源的工具类
 * @Author zhengyongxian
 * @Date 2020/5/9
 */
public class DataSourceUtil {

    /**
     * 用于获取一个连接
     * @param cfg
     * @return
     */
    public static Connection getConnection(Configuration cfg){
        try {
            Class.forName(cfg.getDriver());
            return DriverManager.getConnection(cfg.getUrl(), cfg.getUsername(), cfg.getPassword());
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }
}
