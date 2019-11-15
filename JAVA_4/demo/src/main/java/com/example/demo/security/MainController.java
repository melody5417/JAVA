package com.example.demo.security;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
@RequestMapping("/")
public class MainController {

    @RequestMapping("/")
    public String root() {
        System.out.println("root");
        return "redirect:/index";
    }

    @RequestMapping("/index")
    public String index() {
        System.out.println("index");
        return "index";
    }

    @RequestMapping("/user/index")
    public String userIndex() {
        System.out.println("userIndex");
        return "user/index";
    }

    @RequestMapping("/login")
    public String login(Model model) {
        System.out.println("login");
        return "login";
    }

    @RequestMapping("/login-error")
    public String loginError(Model model) {
        System.out.println("loginError");
        model.addAttribute("loginError", true);
        return "login";
    }

    @ExceptionHandler(value=RuntimeException.class)
    @ResponseStatus(value= HttpStatus.BANDWIDTH_LIMIT_EXCEEDED)
    public String error() {
        System.out.println("error");
        return "error";
    }

}
