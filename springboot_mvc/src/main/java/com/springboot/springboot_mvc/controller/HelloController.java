package com.springboot.springboot_mvc.controller;

import com.sun.javafx.collections.MappingChange;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.Map;

@Controller
public class HelloController {

    @RequestMapping("/hello")
    @ResponseBody
    public String test() {
        return "hello";
    }

    @RequestMapping("thymeleaf")
    public String testThymeleaf(Map<String, Object> map) {
        map.put("hello", "你好");
        map.put("nihao", "<h1>你好</h1>");
        map.put("users", Arrays.asList("张三", "李四", "王五"));
        return "success";

    }
@PostMapping("login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Map<String, Object> map, HttpSession session) {

        if (!StringUtils.isEmpty(username) && "1234".equals(password)) {
         /*  登陆成功  使用重定向防止表单重复提交
            但是重定向又访问不带templates下的资源 所以我们重定向发送一个请求 使用视图控制器来实现跳转
            但是如果这样只要我们直接访问main.html就会直接访问到登陆成功页面，这不安全，所以我们使用拦截器
            对请求进行拦截   先把用户名放进session 然后在配置拦截器 注册拦截器*/
         session.setAttribute("loginUser",username);
            return "redirect:/main.html";

        } else {
            map.put("msg", "用户名密码错误");
            return "index";
        }

    }

}