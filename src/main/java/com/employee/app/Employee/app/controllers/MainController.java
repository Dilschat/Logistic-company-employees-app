package com.employee.app.Employee.app.controllers;

import com.employee.app.Employee.app.model.Order;
import com.employee.app.Employee.app.service.DataClusterCommunication;
import com.employee.app.Employee.app.service.singletones.OrdersToApproveQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;


@Controller
public class MainController {
    @GetMapping("/main")
    public String nextOrder(){
        UserDetails userDetails =
                (UserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String role = userDetails.getAuthorities().iterator().next().getAuthority();
        if (role.equals("ROLE_ControlOperator")) {
            return "thymeleaf/control_manager_main.html";

        } else if(role.equals("ROLE_OrderOperator")){

            return "thymeleaf/order_manager_main";

       }else if(role.equals("ROLE_TopManager")){
            return "thymeleaf/top_manager_main.html";

        }else{
            return "thymeleaf/error/403.html";

        }
    }





}
