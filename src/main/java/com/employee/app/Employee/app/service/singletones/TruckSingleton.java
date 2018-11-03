package com.employee.app.Employee.app.service.singletones;

import com.employee.app.Employee.app.model.Truck;

import java.util.ArrayList;
import java.util.HashMap;

public class TruckSingleton {

    private static volatile TruckSingleton instance;
    private static volatile HashMap<String, HashMap<Long, Truck>> trucks;
    private static final Object lock = new Object();

    private TruckSingleton() {}
    /*
     * something with synchronized
     * don't know why we need it
     * I copy pasted code from wikipedia
     * seems good
     */
    public static TruckSingleton getInstance() {
        TruckSingleton localInstance = instance;
        if (localInstance == null) {
            synchronized (lock) {
                localInstance = instance;
                if (localInstance == null) {
                    instance = localInstance = new TruckSingleton();
                    trucks = new HashMap<>();
                }
            }
        }
        return localInstance;
    }

    public ArrayList<Truck> getTrucks(String username){
        HashMap<Long, Truck> controlOperatorMap = trucks.get(username);
        if (controlOperatorMap == null){
            return new ArrayList<>();
        } else {
            return new ArrayList<>(controlOperatorMap.values());
        }
    }

    public void addTruck(Truck truck){
        HashMap<Long, Truck> controlOperatorMap = trucks.get(truck.getUsername());
        if (controlOperatorMap == null){
            HashMap<Long, Truck> res = new HashMap<>(1);
            res.put(truck.getId(), truck);
            trucks.put(truck.getUsername(), res);
        } else {
            controlOperatorMap.put(truck.getId(), truck);
        }
    }
}
