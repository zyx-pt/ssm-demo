package com.zyx.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * <pre>
 * 描述：TODO
 * </pre>
 *
 * @author zhengyx
 * @email zhengyx@gillion.com.cn
 * @date 2020/9/15
 * @time 18:08
 * @description: TODO
 */
@Controller
public class HelloController {

    @RequestMapping(path="/hello")
    public String sayHello(){
        System.out.println("Hello StringMVC");
        return "success";
    }

}
