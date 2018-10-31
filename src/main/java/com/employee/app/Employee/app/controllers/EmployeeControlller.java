package com.employee.app.Employee.app.controllers;

import com.employee.app.Employee.app.model.Employee;
import com.employee.app.Employee.app.service.DataClusterCommunication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;

@Controller
public class EmployeeControlller {
    @GetMapping("/add_employee")
    public ModelAndView addEmployee(ModelAndView employeeView){
        Employee employee = new Employee();
        employeeView.addObject(employee);
        employeeView.setViewName("thymeleaf/addEmployee");
        return employeeView;
    }

    @PostMapping("/add_employee")
    public String submitOrder(@ModelAttribute Employee employee) throws IOException {
        DataClusterCommunication.registerNewEmployee(employee);
        return "thymeleaf/main";
    }
}
