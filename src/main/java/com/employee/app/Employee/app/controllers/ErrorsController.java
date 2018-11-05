package com.employee.app.Employee.app.controllers;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

@Controller
class ErrorsController {

    @RequestMapping("/404")
    public String handleError() {
        return "thymeleaf/error/404.html";
    }
    @RequestMapping("/400")
    public String handleError1() {
        return "thymeleaf/error/400.html";
    }
    @RequestMapping("/401")
    public String handleError2() {
        return "thymeleaf/error/402.html";
    }
    @RequestMapping("/403")
    public String handleError3() {
        return "thymeleaf/error/403.html";
    }
    @RequestMapping("/500")
    public String handleError4() {
        return "thymeleaf/error/500.html";
    }
    @RequestMapping("/501")
    public String handleError5() {
        return "thymeleaf/error/501.html";
    }
    @RequestMapping("/503")
    public String handleError6() {
        return "thymeleaf/error/503.html";
    }
    @RequestMapping("/520")
    public String handleError7() {
        return "thymeleaf/error/520.html";
    }
    @RequestMapping("/521")
    public String handleError8() {
        return "thymeleaf/error/521.html";
    }
    @RequestMapping("/533")
    public String handleError9() {
        return "thymeleaf/error/533.html";
    }



}
