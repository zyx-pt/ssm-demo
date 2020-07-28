package com.zyx.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

/**
 * @Description:
 * @Author zhengyongxian
 * @Date 2020/7/28 16:41
 */
public class JdbcConfig {

    @Value("${jdbc.driver}")
    private String driver;

    @Value("${jdbc.url}")
    private String url;

    @Value("${jdbc.username}")
    private String username;

    @Value("${jdbc.password}")
    private String password;

    /**
     * @Description: 创建JdbcTemplate
     *
     * @Author: zhengyongxian
     * @Date: 2020/7/28 16:57
     * @param dataSource
     * @return: org.springframework.jdbc.core.JdbcTemplate
     */
    @Bean(name = "jdbcTemplate")
    public JdbcTemplate createJdbcTemplate(DataSource dataSource){
        return new JdbcTemplate(dataSource);
    }

    /**
     * @Description: 创建数据源对象
     *
     * @Author: zhengyongxian
     * @Date: 2020/7/28 16:59
     * @param 
     * @return: javax.sql.DataSource
     */
    @Bean(name = "dataSource")
    public DataSource createDataSource(){
        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
        driverManagerDataSource.setDriverClassName(driver);
        driverManagerDataSource.setUrl(url);
        driverManagerDataSource.setUsername(username);
        driverManagerDataSource.setPassword(password);
        return driverManagerDataSource;
    }

}
