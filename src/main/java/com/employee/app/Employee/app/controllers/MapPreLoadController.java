package com.employee.app.Employee.app.controllers;

import com.employee.app.Employee.app.model.Order;
import com.employee.app.Employee.app.model.Warehouse;
import com.employee.app.Employee.app.service.singletones.WarehousesSingleton;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by niyaz on 08.11.2018.
 */

@PreAuthorize("hasRole('ROLE_ControlOperator')")
@Controller
public class MapPreLoadController {

    @GetMapping("/map")
    public ModelAndView nextOrder(ModelAndView orderView){
        WarehousesSingleton singleton = WarehousesSingleton.getInstance();
        List<HashMap<String, Object>> warehouses = new LinkedList<>();
        for (Warehouse warehouse : singleton.getWarehouses()) {
            HashMap<String, Object> newWarehouse = new HashMap<>(4);
            newWarehouse.put("address", warehouse.getFullAddress());
            newWarehouse.put("id", warehouse.getId());
            newWarehouse.put("latitude", warehouse.getLatitude());
            newWarehouse.put("longitude", warehouse.getLongitude());

            warehouses.add(newWarehouse);
        }


        orderView.addObject(warehouses);
        orderView.setViewName("thymeleaf/maps");
        return orderView;
    }
}
