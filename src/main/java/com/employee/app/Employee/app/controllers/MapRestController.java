package com.employee.app.Employee.app.controllers;

import com.employee.app.Employee.app.model.Truck;
import com.employee.app.Employee.app.service.singletones.TruckSingleton;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.ExposesResourceFor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@ExposesResourceFor(Truck.class)
@RequestMapping("/update_position")
public class MapRestController {

    @Autowired
    private SimpMessageSendingOperations messagingTemplate;

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void post(@RequestBody Truck truck){
        TruckSingleton singleton = TruckSingleton.getInstance();
        singleton.addTruck(truck);

        HashMap<String, Object> res = new HashMap<>(4);
        res.put("type", "truck");
        res.put("id", truck.getId());
        res.put("latitude", truck.getLatitude());
        res.put("longitude", truck.getLongitude());


        messagingTemplate.convertAndSend("/topic/trucks", res);
    }
}
