package com.employee.app.Employee.app.controllers;

import com.employee.app.Employee.app.model.Truck;
import com.employee.app.Employee.app.service.singletones.TruckSingleton;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class MapsController {

    @Autowired
    private SimpMessageSendingOperations messagingTemplate;

    @RequestMapping(value = "/empoyee_map", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void putNewPosition(@RequestBody Truck positionModel){
        messagingTemplate.convertAndSend("/topic/public", positionModel);
        System.out.println("new truck");
    }

    @GetMapping("/empoyee_map_get")
    public ArrayList<Truck> getPositions(){
        return TruckSingleton.getInstance().getTrucks();
    }
}
