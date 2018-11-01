package com.employee.app.Employee.app.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionConnectedEvent;

@Component
public class WebSocketEventListener {

    private static final Logger logger = LoggerFactory.getLogger(WebSocketEventListener.class);

    @Autowired
    private SimpMessageSendingOperations messagingTemplate;

    @EventListener
    public void handleWebSocketConnectListener(SessionConnectedEvent event) {
        logger.info("Received a new web socket connection");
        /*
        if (event.getUser() != null && event.getUser().getName() != null){
            HashMap<String, Object> res = new HashMap<>(2);
            res.put("type", "trucks_list");
            res.put("list", TruckSingleton.getInstance().getTrucks(event.getUser().getName()));
            messagingTemplate.convertAndSendToUser(event.getUser().getName(), "/queue/reply", res);
        }*/

    }
}
