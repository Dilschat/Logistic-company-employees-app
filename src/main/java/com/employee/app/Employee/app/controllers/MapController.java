package com.employee.app.Employee.app.controllers;

import com.employee.app.Employee.app.model.Truck;
import com.employee.app.Employee.app.model.Warehouse;
import com.employee.app.Employee.app.service.singletones.TruckSingleton;
import com.employee.app.Employee.app.service.singletones.WarehousesSingleton;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.ExposesResourceFor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@ExposesResourceFor(Truck.class)
@RequestMapping("/all_trucks")
public class MapController {

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Truck> getTrucks() {
        TruckSingleton singleton = TruckSingleton.getInstance();
        return singleton.getTrucks();
    }
}