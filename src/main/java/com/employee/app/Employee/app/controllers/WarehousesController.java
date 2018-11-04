package com.employee.app.Employee.app.controllers;

import com.employee.app.Employee.app.model.Truck;
import com.employee.app.Employee.app.model.Warehouse;
import com.employee.app.Employee.app.service.singletones.TruckSingleton;
import com.employee.app.Employee.app.service.singletones.WarehousesSingleton;
import org.springframework.hateoas.ExposesResourceFor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by niyaz on 04.11.2018.
 */
@RestController
@RequestMapping("/all_warehouses")
public class WarehousesController {

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<HashMap<String, Object>> getWarehouses(){
        WarehousesSingleton singleton = WarehousesSingleton.getInstance();
        List<HashMap<String, Object>> result = new LinkedList<>();
        for (Warehouse warehouse : singleton.getWarehouses()) {
            HashMap<String, Object> newWarehouse = new HashMap<>(4);
            newWarehouse.put("address", warehouse.getFullAddress());
            newWarehouse.put("id", warehouse.getId());
            newWarehouse.put("latitude", warehouse.getLatitude());
            newWarehouse.put("longitude", warehouse.getLongitude());

            result.add(newWarehouse);
        }
        return result;
    }
}
