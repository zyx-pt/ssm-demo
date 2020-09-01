package com.zyx.service.impl;

import com.zyx.service.AccountService;
import com.zyx.utils.MyAnnotation;
import org.springframework.aop.framework.AopContext;
import org.springframework.stereotype.Service;

/**
 * 账户的业务层实现类
 */
@Service("accountServiceImpl")
public class AccountServiceImpl implements AccountService {

    @Override
    public void saveAccount() {
        System.out.println("执行方法: saveAccount,------------保存");
    }

    @Override
    public void updateAccount(int i) {
        System.out.println("开始更新------------");
        // 如果我们在service层 A方法中，调用B方法，切点切的是B方法，那么这时候是不会切入的
        // 解决办法->在A方法中使用((Service)AopContext.currentProxy()).B() 来调用B方法

        // 开启aspecyj expose-proxy暴露AOP代理到ThreadLocal, proxy-target-class设置使用cglib代理对象
        // <aop:aspectj-autoproxy expose-proxy="true" proxy-target-class="true"/>

        // spring boot注解要加上@EnableAspectJAutoProxy(exposeProxy = true, proxyTargetClass = true)来暴露AOP的Proxy对象

        ((AccountService)AopContext.currentProxy()).updateOther();
        // proxy-target-class="true"配置后才能代理接口的实现类
        ((AccountServiceImpl)AopContext.currentProxy()).updateStatus();
    }


    @Override
    public int deleteAccount() {
        System.out.println("执行方法: deleteAccount,------------删除");
        return 0;
    }

    @Override
    @MyAnnotation(value = "updateOther")
    public void updateOther(){
        System.out.println("执行方法: updateOther,------------更新其他信息");
    }

    @MyAnnotation(value = "updateStatus")
    public void updateStatus(){
        System.out.println("执行方法: updateStatus,------------更新状态");
    }

}
