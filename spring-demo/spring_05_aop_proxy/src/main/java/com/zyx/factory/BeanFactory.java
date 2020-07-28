package com.zyx.factory;

import com.zyx.entity.model.Account;
import com.zyx.service.AccountService;
import com.zyx.utils.TransactionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 用于创建service的代理对象的工厂
 * @Author zhengyongxian
 * @Date 2020/5/26
 */
@Component
public class BeanFactory {

    @Autowired
    private AccountService accountService;

    @Autowired
    private TransactionManager txManager;

    /**
     * 获取Service代理对象
     * @return
     */
    public AccountService getAccountService() {
        return (AccountService)Proxy.newProxyInstance(accountService.getClass().getClassLoader(),
                accountService.getClass().getInterfaces(),
                new InvocationHandler() {
                    // 添加事务的支持
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

                        if("test".equals(method.getName())){
                            return method.invoke(accountService,args);
                        }

                        Object rtValue = null;
                        try {
                            //1.开启事务
                            txManager.beginTransaction();
                            //2.执行操作
                            rtValue = method.invoke(accountService, args);
                            //3.提交事务
                            txManager.commit();
                            //4.返回结果
                            return rtValue;
                        } catch (Exception e) {
                            //5.回滚操作
                            txManager.rollback();
                            throw new RuntimeException(e);
                        } finally {
                            //6.释放连接
                            txManager.release();
                        }
                    }
                });

    }

    public AccountService getAccountServiceUseLambd(){
        Object proxyInstance = Proxy.newProxyInstance(accountService.getClass().getClassLoader(), accountService.getClass().getInterfaces(),
                (proxy, method, args) -> {
                    if ("test".equals(method.getName())) {
                        return method.invoke(accountService, args);
                    }

                    Object rtValue = null;
                    try {
                        //1.开启事务
                        txManager.beginTransaction();
                        //2.执行操作
                        rtValue = method.invoke(accountService, args);
                        //3.提交事务
                        txManager.commit();
                        //4.返回结果
                        return rtValue;
                    } catch (Exception e) {
                        //5.回滚操作
                        txManager.rollback();
                        throw new RuntimeException(e);
                    } finally {
                        //6.释放连接
                        txManager.release();
                    }
                });
        AccountService accountServiceProxy = (AccountService) proxyInstance;
        return accountServiceProxy;
    }
}
