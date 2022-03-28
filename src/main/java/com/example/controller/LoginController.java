package com.example.controller;

import com.example.pojo.User;
import com.example.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {
    @Autowired
    UserService userService;
    @RequestMapping("/")
    public String toLogin(){
        return "login";
    }

    @RequestMapping("/login")
    public String toIndex(@RequestParam("username")String username,
                          @RequestParam("password")String password,
                          Model model, HttpSession session) {
        //注册可以加密
        User user=userService.selectByname(username); //登录完成后，向页面发送数据发送的是整个用户，页面需要什么用什么

        session.setAttribute("username",username);
//        model.addAttribute("username",username);
        //获取当前用户
        Subject subject = SecurityUtils.getSubject();
        //封装用户登录的数据
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        //
        try {
            subject.login(token);
            return "index";
        } catch (UnknownAccountException e) { //用户名不存在
            model.addAttribute("msg", "用户名错误！");
            return "login";
        } catch (IncorrectCredentialsException e) { //密码不存在
            model.addAttribute("msg", "密码错误！");
            return "login";
        }
    }
    @RequestMapping("/toadd")
    public String toAdd(){
        return "add";
    }
    @RequestMapping("/addUser")
    public String addUser(User user){
        userService.addUser(user);
        return "login";
    }
    @RequestMapping("/logout")
    public String logOut(){
        return "login";
    }
    @RequestMapping("/level1/1")
    public String tol11(){
        return "views/level1/1";
    }
    @RequestMapping("/level1/2")
    public String tol12(){
        return "views/level1/2";
    }
    @RequestMapping("/level1/3")
    public String tol13(){
        return "views/level1/3";
    }
}
