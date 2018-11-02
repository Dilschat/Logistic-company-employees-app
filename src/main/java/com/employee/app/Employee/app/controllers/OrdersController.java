package com.employee.app.Employee.app.controllers;

import com.employee.app.Employee.app.model.Order;
import com.employee.app.Employee.app.service.DataClusterCommunication;
import com.employee.app.Employee.app.service.singletones.OrdersToApproveQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;


@PreAuthorize("hasRole('orderOperator')")
@Controller
public class OrdersController {

    private final OrdersToApproveQueue ordersQueue;

    @Autowired
    public OrdersController(OrdersToApproveQueue ordersQueue) {
        this.ordersQueue = ordersQueue;
    }

    @PreAuthorize("hasRole('orderOperator')")

    @GetMapping("/next_order")
    public ModelAndView nextOrder(ModelAndView orderView){
 //       Order order = ordersQueue.getOrder();
        Order order = new Order();
        orderView.addObject(order);
        orderView.setViewName("thymeleaf/OpenOrder");
        return orderView;
    }
    @PreAuthorize("hasRole('orderOperator')")

    @GetMapping("/add_order")
    public ModelAndView addOrder(ModelAndView orderView){
        Order order = new Order();
        orderView.addObject(order);
        orderView.setViewName("thymeleaf/OpenOrder");
        return orderView;
    }

    @PreAuthorize("hasRole('orderOperator')")

    @PostMapping("/next_order")
    public String submitOrder(@ModelAttribute Order order, @RequestParam(value="action", required=true) String action) throws IOException {
        if(action.equals("Submit")){
            System.out.println("Submit\n");
        }
        DataClusterCommunication.approveOrder(order);
        return "thymeleaf/continue";
    }


}
