package com.employee.app.Employee.app.controllers;

import com.employee.app.Employee.app.service.DataClusterCommunication;
import com.employee.app.Employee.app.service.daemons.OrdersToApproveQueue;
import com.employee.app.Employee.app.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;

@Controller
public class OrdersController {

    private final OrdersToApproveQueue ordersQueue;

    @Autowired
    public OrdersController(OrdersToApproveQueue ordersQueue) {
        this.ordersQueue = ordersQueue;
    }


    @GetMapping("/next_order")
    public ModelAndView nextOrder(ModelAndView orderView){
        Order order = ordersQueue.getOrder();
        orderView.addObject(order);
        orderView.setViewName("thymeleaf/addOrder");
        return orderView;
    }

    @GetMapping("/add_order")
    public ModelAndView addOrder(ModelAndView orderView){
        Order order = new Order();
        orderView.addObject(order);
        orderView.setViewName("thymeleaf/addOrder");
        return orderView;
    }


    @PostMapping("/next_order")
    public String submitOrder(@ModelAttribute Order order, @RequestParam(value="action", required=true) String action) throws IOException {
        if(action.equals("Submit")){
            System.out.println("Submit\n");
        }
        DataClusterCommunication.approveOrder(order);
        return "thymeleaf/continue";
    }
}
