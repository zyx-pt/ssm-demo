package com.zyx.utils;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * 用于记录日志的工具类，它里面提供了公共的代码
 */
@Component("loggerAnno")
@Aspect // 表示当前类是一个切面类
public class LoggerAnno {

    /**
     * 指定切入点表达式
     */
    @Pointcut("execution(* com.zyx.service.impl.*.*(..))")
    private void pl1(){}

    /**
     * 用于打印日志：计划让其在切入点方法执行之前执行（切入点方法就是业务层方法）
     */
    public  void printLog(){
        System.out.println("Logger类中的printLog方法开始记录日志了。。。");
    }

    /**
     * 前置通知
     */
//    @Before("pl1()") // 使用指定切入点表达式一定要加括号
//    @Before("execution(* com.zyx.service.impl.*.*(..))")
    public  void beforePrintLog(){
        System.out.println("前置通知Logger类中的beforePrintLog方法开始记录日志了。。。");
    }

    /**
     * 后置通知
     */
//    @After("pl1()")
//    @After("execution(* com.zyx.service.impl.*.*(..))")
    public  void afterReturningPrintLog(){
        System.out.println("后置通知Logger类中的afterReturningPrintLog方法开始记录日志了。。。");
    }
    /**
     * 异常通知
     */
//    @AfterThrowing("pl1()")
//    @AfterThrowing("execution(* com.zyx.service.impl.*.*(..))")
    public  void afterThrowingPrintLog(){
        System.out.println("异常通知Logger类中的afterThrowingPrintLog方法开始记录日志了。。。");
    }

    /**
     * 最终通知
     */
//    @After("pl1()")
//    @After("execution(* com.zyx.service.impl.*.*(..))")
    public  void afterPrintLog(){
        System.out.println("最终通知Logger类中的afterPrintLog方法开始记录日志了。。。");
    }

    /**
     * 环绕通知
     * 问题：
     *      当我们配置了环绕通知之后，切入点方法没有执行，而通知方法执行了。
     * 分析：
     *      通过对比动态代理中的环绕通知代码，发现动态代理的环绕通知有明确的切入点方法调用，而我们的代码中没有。
     * 解决：
     *      Spring框架为我们提供了一个接口：ProceedingJoinPoint。该接口有一个方法proceed()，此方法就相当于明确调用切入点方法。
     *      该接口可以作为环绕通知的方法参数，在程序执行时，spring框架会为我们提供该接口的实现类供我们使用。
     *
     * spring中的环绕通知：
     *      它是spring框架为我们提供的一种可以在代码中手动控制增强方法何时执行的方式。
     */
//    @Around("execution(* com.zyx.service.impl.*.*(..))")
//    @Around("pl1()")
    public Object aroundPrintLog(ProceedingJoinPoint pjp){
        Object rtValue = null;
        try{
            // 得到方法执行所需的参数
            Object[] args = pjp.getArgs();
            // 前置通知 -- 开启事务
            beforePrintLog();
            // 执行方法（切入点方法）
            rtValue = pjp.proceed(args);
            // int i = 1/0;
            // 后置通知 -- 提交事务
            afterReturningPrintLog();
            return rtValue;
        }catch (Throwable t){
            // 异常通知 -- 回滚事务
            afterThrowingPrintLog();
            throw new RuntimeException(t);
        }finally {
            // 最终通知 -- 释放资源
            afterPrintLog();
        }
    }

    /**
     * @Description: 设置环绕切面在自定义的注解上
     *
     * @Author: zhengyongxian
     * @Date: 2020/7/23 10:28
     * @param pjp
     * @param myAnnotation
     * @return: java.lang.Object
     */
    @Around("@annotation(myAnnotation)")
    public Object aroundAnnotationTest(ProceedingJoinPoint pjp, MyAnnotation myAnnotation){
        Object rtValue = null;
        try{
            // 得到方法执行所需的参数
            Object[] args = pjp.getArgs();
            // 前置通知 -- 开启事务
            beforePrintLog();
            // 执行方法（切入点方法）
            rtValue = pjp.proceed(args);
            // int i = 1/0;
            // 后置通知 -- 提交事务
            afterReturningPrintLog();
            return rtValue;
        }catch (Throwable t){
            // 异常通知 -- 回滚事务
            afterThrowingPrintLog();
            throw new RuntimeException(t);
        }finally {
            // 最终通知 -- 释放资源
            afterPrintLog();
        }
    }
}