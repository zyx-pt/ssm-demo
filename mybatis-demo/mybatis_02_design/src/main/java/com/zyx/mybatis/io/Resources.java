package com.zyx.mybatis.io;

import java.io.InputStream;

/**
 * 使用类加载器读取配置文件的类
 * @Author zhengyongxian
 * @Date 2020/5/9
 */
public class Resources {
    public static InputStream getResourceAsStream(String fliePath){
        return Resources.class.getClassLoader().getResourceAsStream(fliePath);
    }
}
