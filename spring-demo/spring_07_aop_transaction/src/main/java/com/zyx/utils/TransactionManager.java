package com.zyx.utils;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.SQLException;

/**
 * @Description: 和事务管理相关的工具类，它包含了，开启事务，提交事务，回滚事务和释放连接
 * @Author zhengyongxian
 * @Date 2020/7/25 17:25
 */
@Component("txManager")
@Aspect
public class TransactionManager {

    @Autowired
    private ConnectionUtils connectionUtils;

    /**
     * @Description: 开启事务
     *
     * @Author: zhengyongxian
     * @Date: 2020/7/25 17:28
     * @param
     * @return: void
     */
    public void beginTransaction(){
        try {
            connectionUtils.getThreadConnection().setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * @Description: 提交事务
     *
     * @Author: zhengyongxian
     * @Date: 2020/7/25 17:29
     * @param
     * @return: void
     */

    public void commit(){
        try {
            connectionUtils.getThreadConnection().commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * @Description: 回滚事务
     *
     * @Author: zhengyongxian
     * @Date: 2020/7/25 17:32
     * @param
     * @return: void
     */public void rollback(){
        try {
            connectionUtils.getThreadConnection().rollback();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * @Description: 释放连接
     *
     * @Author: zhengyongxian
     * @Date: 2020/7/25 17:31
     * @param
     * @return: void
     */
    public void release(){
        try {
            connectionUtils.getThreadConnection().close();
            connectionUtils.removeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Pointcut("execution(* com.zyx.service.impl.*.*(..))")
    private void pt1(){}

    @Around("pt1()")
    public Object aroundActive(ProceedingJoinPoint proceedingJoinPoint){
        Object returnValue = null;
        try {
            // 获取参数
            Object[] args = proceedingJoinPoint.getArgs();
            // 开启事务
            this.beginTransaction();
            // 执行方法
            returnValue = proceedingJoinPoint.proceed(args);
            // 提交事务
            this.commit();
            // 返回结果
            return returnValue;
        }catch (Throwable throwable) {
            // 回滚事务
            this.rollback();
            throw new RuntimeException(throwable);
        } finally {
            // 释放资源
            this.release();
        }
    }

}

