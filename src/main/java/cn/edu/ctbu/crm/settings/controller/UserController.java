package cn.edu.ctbu.crm.settings.controller;

import cn.edu.ctbu.crm.exception.LoginException;
import cn.edu.ctbu.crm.settings.domain.User;
import cn.edu.ctbu.crm.settings.service.UserService;
import cn.edu.ctbu.crm.utils.MD5Util;
import cn.edu.ctbu.crm.utils.PrintJson;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService service;
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public void login(String loginAct, String loginPwd, HttpServletRequest request, HttpServletResponse response) throws LoginException {
        //将密码的明文形式转换为MD5形式、
        loginPwd = MD5Util.getMD5(loginPwd);
        //接受浏览器端的ip地址
        String ip = request.getRemoteAddr();
        System.out.println("---------------------->ip"+ip);
        User user = service.login(loginAct,loginPwd,ip);
        //如果程序执行到这里，证明业务层没有为controller抛任何异常，表示登录成功
        request.getSession().setAttribute("user",user);
        PrintJson.printJsonFlag(response,true);
    }
    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String login(){

        return "index";
    }
}
