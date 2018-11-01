//package com.employee.app.Employee.app.controllers;
//
//import org.springframework.boot.web.servlet.error.ErrorController;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import javax.servlet.RequestDispatcher;
//import javax.servlet.http.HttpServletRequest;
//
//@Controller
//class ErrorsController implements ErrorController {
//
//    @RequestMapping("/errors")
//    public String handleError(HttpServletRequest request) {
//        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
//        Integer statusCode = Integer.valueOf(status.toString());
//
//        System.out.println("AAAAA");
//        switch (statusCode) {
//            case 400: {
//                break;
//            }
//            case 401: {
//                return "404";
//            }
//            case 404: {
//                return "404";
//
//            }
//            case 500: {
//                break;
//            }
//        }
//        return "404";
//    }
//
//    @Override
//    public String getErrorPath() {
//        return "/error";
//    }
//}
