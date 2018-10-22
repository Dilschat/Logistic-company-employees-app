package com.employee.app.Employee.app.controllers;

import com.employee.app.Employee.app.model.Truck;
import com.employee.app.Employee.app.model.TrucksLocation;
import com.employee.app.Employee.app.service.singletones.TruckSingleton;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;

@Controller
public class MapController {


    @GetMapping("/map/all_trucks")
    public TrucksLocation getTrucks(){
        AbstractAuthenticationToken auth = (AbstractAuthenticationToken)
                SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();

        return new TrucksLocation();
    }

    /*
    @GetMapping("/map")
    public ArrayList<Truck> getAllTrucks(){
        AbstractAuthenticationToken auth = (AbstractAuthenticationToken)
                SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();
        TruckSingleton truckSingleton = TruckSingleton.getInstance();
        return truckSingleton.getTrucks();
    }
    */
}
