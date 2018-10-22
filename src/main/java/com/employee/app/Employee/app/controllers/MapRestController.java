package com.employee.app.Employee.app.controllers;

import com.employee.app.Employee.app.model.Truck;
import org.springframework.hateoas.ExposesResourceFor;
import org.springframework.hateoas.MediaTypes;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@ExposesResourceFor(Truck.class)
@RequestMapping("/update_position")
public class MapRestController {


    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void post(@RequestBody Truck truck){
        System.out.println(truck.getId());
        System.out.println(truck.getLatitude());
        System.out.println(truck.getLongitude());
    }
}
