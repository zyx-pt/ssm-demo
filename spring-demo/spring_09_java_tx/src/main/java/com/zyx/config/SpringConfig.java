package com.zyx.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @Description: 使用纯Java的配置
 * @Author zhengyongxian
 * @Date 2020/7/28 16:42
 */
@Configuration
@ComponentScan(value={"com.zyx","com"})
@Import({JdbcConfig.class, TransactionConfig.class})
@PropertySource(value = "classpath:jdbcConfig.properties")
@EnableTransactionManagement
public class SpringConfig {

}
