package com.zyx.controller;

import com.zyx.domain.User;
import com.zyx.exception.SysException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <pre>
 * 描述：TODO
 * </pre>
 *
 * @author zhengyx
 * @email zhengyx@gillion.com.cn
 * @date 2020/9/21
 * @time 17:39
 * @description: TODO
 */
@Controller
@RequestMapping("/user")
public class UserController {

    /**
     * 返回String
     * @param model
     * @return
     */
    @RequestMapping("/testString")
    public String testString(Model model){
        System.out.println("testString方法执行了...");
        // 模拟从数据库中查询出User对象
        User user = new User();
        user.setUsername("hehe");
        user.setPassword("123");
        user.setAge(18);
        // model对象
        model.addAttribute("user",user);
        return "success";
    }

    /**
     * 是void，默认请求后重定向为/user/testVoid.jsp
     * 请求转发一次请求，不用编写项目的名称
     */
    @RequestMapping("/testVoid")
    public void testVoid(HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println("testVoid方法执行了...");
        // 编写请求转发的程序
        // request.getRequestDispatcher("/WEB-INF/pages/success.jsp").forward(request,response);

        // 重定向
//        String contextPath = request.getContextPath();
//        response.sendRedirect(contextPath +"/index.jsp");

        // 设置中文乱码
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        // 直接会进行响应
        response.getWriter().print("你好");

        return;
    }

    /**
     * 返回ModelAndView
     * @return
     */
    @RequestMapping("/testModelAndView")
    public ModelAndView testModelAndView(){
        // 创建ModelAndView对象
        ModelAndView mv = new ModelAndView();
        System.out.println("testModelAndView方法执行了...");
        // 模拟从数据库中查询出User对象
        User user = new User();
        user.setUsername("小凤");
        user.setPassword("456");
        user.setAge(30);

        // 把user对象存储到mv对象中，也会把user对象存入到request对象
        mv.addObject("user",user);

        // 跳转到哪个页面
        mv.setViewName("success");

        return mv;
    }

    /**
     * 使用关键字的方式进行转发或者重定向
     * @return
     */
    @RequestMapping("/testForwardOrRedirect")
    public String testForwardOrRedirect(){
        System.out.println("testForwardOrRedirect方法执行了...");

        // 请求的转发
        // return "forward:/WEB-INF/pages/success.jsp";

        // 重定向
        return "redirect:/index.jsp";
    }

    /**
     * 模拟异步请求响应
     */
    @RequestMapping("/testAjax")
    @ResponseBody
    public User testAjax(@RequestBody User user){
        System.out.println("testAjax方法执行了...");
        // 客户端发送ajax的请求，传的是json字符串，后端把json字符串封装到user对象中
        System.out.println(user);
        // 做响应，模拟查询数据库
        user.setUsername("haha");
        user.setAge(40);
        // 做响应
        return user;
    }

    /**
     * 测试拦截器
     */
    @RequestMapping("/testException")
    public String testException() throws SysException {
        System.out.println("testException执行了...");

        try {
            // 模拟异常
            int a = 10/0;
        } catch (Exception e) {
            // 打印异常信息
            e.printStackTrace();
            // 抛出自定义异常信息
            throw new SysException("查询所有用户出现错误了...");
        }
        return "success";
    }

    /**
     * 测试异常处理
     */
    @RequestMapping("/testInterceptor")
    public String testInterceptor(){
        System.out.println("testInterceptor执行了...");
        return "success";
    }
}
