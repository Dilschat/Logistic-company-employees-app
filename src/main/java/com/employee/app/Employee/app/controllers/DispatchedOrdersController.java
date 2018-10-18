package com.employee.app.Employee.app.controllers;

import com.employee.app.Employee.app.model.DispatchedOrder;
import com.employee.app.Employee.app.model.Order;
import com.employee.app.Employee.app.service.DataClusterCommunication;
import com.employee.app.Employee.app.service.daemons.OrdersToApproveQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.List;

@Controller
public class DispatchedOrdersController {
    private final DataClusterCommunication ordersService;

    @Autowired
    public DispatchedOrdersController(DataClusterCommunication ordersService) {
        this.ordersService = ordersService;
    }

    @GetMapping("/dispatched_orders")
    public String getDispatchedOrders(Model dispathedOrders){
        List<DispatchedOrder> orders = ordersService.geDispatchedOrders();
        dispathedOrders.addAttribute("orders", orders);
        return "thymeleaf/orderList";
    }


    @GetMapping(value = "/dispatched_orders", params = {"id"})
    public String getOrderDetails(Model order, @RequestParam(value = "id") String id){
        DispatchedOrder dispatchedOrder =  ordersService.geDispatchedOrder(id);
        order.addAttribute("order", dispatchedOrder);
        return "thymeleaf/dispatchedOrderDetails";
    }

    @PostMapping(value = "/dispatched_orders")
    public String submitOrderDetails(@ModelAttribute Order order){
        try {
            DataClusterCommunication.approveOrder(order);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "thymeleaf/continue";
    }
}
