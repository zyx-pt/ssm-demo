package com.zyx.controller;

import com.zyx.domain.Account;
import com.zyx.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * <pre>
 * 描述：测验SpringMVC
 * </pre>
 *
 * @Author zhengyongxian
 * @Date 2020/9/30 13:47
 * @Description: TODO
 */

@Controller
@RequestMapping("/account")
public class AccountController {
    @Autowired
    private AccountService accountService;

    @RequestMapping("/findAll")
    public String findAll() {
        System.out.println("执行了查询账户");
        return "success";
    }

    /**
     * 保存后响应
     */
    @RequestMapping("/findAllAccount")
    public ModelAndView findAllAccount() {
        List<Account> accounts = accountService.findAllAccount();
        ModelAndView mv = new ModelAndView();
        mv.addObject("accounts", accounts);
        mv.setViewName("accountList");
        return mv;
    }

//    @RequestMapping("/findAllAccount")
//    public String findAllAccount(Model model){
//        System.out.println("表现层：查询所有账户...");
//        // 调用service的方法
//        List<Account> accounts = accountService.findAllAccount();
//        model.addAttribute("accounts",accounts);
//        return "accountList";
//    }

    /**
     * 保存
     * @return
     */
    @RequestMapping("/saveAccount")
    public String saveAccount(Account account) {
        accountService.saveAccount(account);
        return "redirect:findAllAccount";
    }

//    @RequestMapping("/saveAccount")
//    public void saveAccount(Account account, HttpServletRequest request, HttpServletResponse response) throws IOException {
//        accountService.saveAccount(account);
//        response.sendRedirect(request.getContextPath()+"/account/findAllAccount");
//        return;
//    }
}
