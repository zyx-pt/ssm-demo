package com.zyx.entity.mybatis.proxy;

import com.zyx.entity.mybatis.config.Mapper;
import com.zyx.entity.mybatis.utils.Executor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.util.Map;

/**
 * @Author zhengyongxian
 * @Date 2020/5/9
 */
public class MapperProxy implements InvocationHandler {

    private Map<String, Mapper> mappers;
    private Connection connection;

    public MapperProxy(Map<String, Mapper> mappers, Connection connection) {
        this.mappers = mappers;
        this.connection = connection;
    }

    /**
     * 用于对方法进行增强 --> 调用selectList方法
     * @param proxy
     * @param method
     * @param args
     * @return
     * @throws Throwable
     */
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        String methodName = method.getName();

        String className = method.getDeclaringClass().getName();

        String key = className + "." + methodName;

        Mapper mapper  = mappers.get(key);

        if (mapper == null) {
            throw new IllegalArgumentException("传入的参数有误");
        }

        return new Executor().selectList(mapper, connection);
    }
}
