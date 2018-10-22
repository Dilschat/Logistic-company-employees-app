package com.employee.app.Employee.app.service.daemons;

import com.employee.app.Employee.app.websocket.TruckLocation;
import javafx.util.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessageSendingOperations;

/**
 * Created by niyaz on 19.10.2018.
 */
public class TruckPlaceManager implements Runnable{

    @Autowired
    private SimpMessageSendingOperations messagingTemplate;

    private Pair<Long, Long> truck1, truck2;
    private TruckLocation t1 = new TruckLocation(1), t2 = new TruckLocation(2);

    public TruckPlaceManager() {
        truck1 = new Pair<>(System.currentTimeMillis() / 3000, (long) 3000);
        truck2 = new Pair<>(System.currentTimeMillis() / 2500, (long) 2500);

    }

    @Override
    public void run() {
        /*
        while(true){
            if (System.currentTimeMillis() / truck1.getValue() > truck1.getKey()){
                truck1 = new Pair<>(System.currentTimeMillis() / 3000, (long) 3000);
                t1.generateCoordinates();
                messagingTemplate.convertAndSend("/topic/public", t1);
                Thread.yield();
            }
            if (System.currentTimeMillis() / truck2.getValue() > truck2.getKey()){
                truck2 = new Pair<>(System.currentTimeMillis() / 2500, (long) 2500);
                t2.generateCoordinates();
                messagingTemplate.convertAndSend("/topic/public", t2);
                Thread.yield();
            }
        }
        */

    }

}
