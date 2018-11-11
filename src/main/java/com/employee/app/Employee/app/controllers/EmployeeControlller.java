package com.employee.app.Employee.app.controllers;

import com.employee.app.Employee.app.model.Employee;
import com.employee.app.Employee.app.service.DataClusterCommunication;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;

@Controller
@PreAuthorize("hasRole('ROLE_TopManager')")

public class EmployeeControlller {
    @GetMapping("/add_employee")
    public ModelAndView addEmployee(ModelAndView employeeView) {
        Employee employee = new Employee();
        employeeView.addObject(employee);
        employeeView.setViewName("thymeleaf/addEmployee");
        return employeeView;
    }

    @PostMapping("/add_employee")
    public String submitOrder(@ModelAttribute Employee employee) throws IOException {
        if (!employee.getLogin().isEmpty() && !employee.getPasswordHash().isEmpty()) {
            DataClusterCommunication.registerNewEmployee(employee);
            return "thymeleaf/add_employee_continue";
        } else {
            return "thymeleaf/add_employee_cont_error";
        }

    }

    @GetMapping("/employees")
    public ModelAndView getList( ModelAndView employeeView, @RequestParam(value = "login", required = false) String login) throws IOException {
        if(login!=null){
            DataClusterCommunication.deleteEmployee(login);
        }
        employeeView.addObject("employees", DataClusterCommunication.getEmployeesList());
        employeeView.setViewName("thymeleaf/employeeList");
        return employeeView;
    }
}


