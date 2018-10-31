package com.employee.app.Employee.app.controllers;

import com.employee.app.Employee.app.model.DispatchedOrder;
import com.employee.app.Employee.app.model.Order;
import com.employee.app.Employee.app.service.DataClusterCommunication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class DispatchedOrdersController {
    private final DataClusterCommunication ordersService;

    @Autowired
    public DispatchedOrdersController(DataClusterCommunication ordersService) {
        this.ordersService = ordersService;
    }

    @GetMapping("/dispatched_orders")
    public ModelAndView getDispatchedOrders(ModelAndView orderView){
        List<Order> orders = ordersService.geDispatchedOrders();
        orderView.addObject(orders);
        orderView.setViewName("thymeleaf/orderList");
        return orderView;
    }

    @GetMapping(value = "/dispatched_orders", params = {"id"})
    public ModelAndView getOrderDetails(ModelAndView orderView, @RequestParam(value = "id") String id){
        DispatchedOrder order = ordersService.geDispatchedOrder(id);
        orderView.addObject(order);
        orderView.setViewName("thymeleaf/dispatchedOrderDetails");
        return orderView;
    }
}
