package com.zyx.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 和事务管理相关的工具类，包含开启事务、提交事务、回滚事务、释放连接
 * @Author zhengyongxian
 * @Date 2020/5/26
 */
@Component
public class TransactionManager {
    @Autowired
    private ConnectionBindUtils connectionBindUtils;

    /**
     * 开启事务
     */
    public  void beginTransaction(){
        try {
            connectionBindUtils.getThreadConnection().setAutoCommit(false);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 提交事务
     */
    public  void commit(){
        try {
            connectionBindUtils.getThreadConnection().commit();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 回滚事务
     */
    public  void rollback(){
        try {
            connectionBindUtils.getThreadConnection().rollback();
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    /**
     * 释放连接
     */
    public  void release(){
        try {
            connectionBindUtils.getThreadConnection().close();//还回连接池中
            connectionBindUtils.removeConnection();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
