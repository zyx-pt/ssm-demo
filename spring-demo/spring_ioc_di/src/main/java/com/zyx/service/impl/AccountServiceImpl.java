package com.zyx.service.impl;

import com.zyx.service.AccountService;

import java.util.Date;

/**
 * @Author zhengyongxian
 * @Date 2020/5/22
 */
public class AccountServiceImpl implements AccountService {
    //如果是经常变化的数据，并不适用于注入的方式
    private String name;
    private Integer age;
    private Date birthday;

    public AccountServiceImpl(String name,Integer age,Date birthday){
        this.name = name;
        this.age = age;
        this.birthday = birthday;
    }


    public AccountServiceImpl(){
        System.out.println("使用无参的构造器创建对象。。。");
    }

    public void  saveAccount(){
        System.out.println("service中的saveAccount方法执行了。。。"+name+","+age+","+birthday);
    }


    public void  init(){
        System.out.println("对象初始化了。。。");
    }
    public void  destroy(){
        System.out.println("对象销毁了。。。");
    }
}
