package com.employee.app.Employee.app.controllers;

import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MapController {


    /*
    @GetMapping("/map/all_trucks")
    public TrucksLocation getTrucks(){
        AbstractAuthenticationToken auth = (AbstractAuthenticationToken)
                SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();
        System.out.println(name);

        return new TrucksLocation();
    }*/
}
