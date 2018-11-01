package com.employee.app.Employee.app.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/home").setViewName("thymeleaf/home");
        registry.addViewController("/").setViewName("thymeleaf/order_manager_main");
        registry.addViewController("/main").setViewName("thymeleaf/order_manager_main");
        registry.addViewController("/login").setViewName("thymeleaf/login");
        registry.addViewController("/control_main").setViewName("thymeleaf/control_manager_main.html");

    }

}