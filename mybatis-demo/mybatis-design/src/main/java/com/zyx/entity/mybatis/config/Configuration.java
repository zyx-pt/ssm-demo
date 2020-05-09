package com.zyx.entity.mybatis.config;

import java.util.HashMap;
import java.util.Map;

/**
 * 自定义mybatis的配置类
 * @Author zhengyongxian
 * @Date 2020/5/9
 */
public class Configuration {
    private String driver;
    private String url;
    private String username;
    private String password;

    // 设值的时候要使用追加的方式
    private Map<String, Mapper> mappers = new HashMap<String, Mapper>();

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Map<String, Mapper> getMappers() {
        return mappers;
    }

    public void setMappers(Map<String, Mapper> mappers) {
        // 处需要使用追加
        this.mappers.putAll(mappers);
    }
}
