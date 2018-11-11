package com.employee.app.Employee.app.service.singletones;

import com.employee.app.Employee.app.model.Truck;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class TruckSingleton {

    private static volatile TruckSingleton instance;
    private static volatile List<Truck> trucks;
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
                    trucks = new LinkedList<>();
                }
            }
        }
        return localInstance;
    }

    public List<Truck> getTrucks(){
        return trucks;
    }

    public void addTruck(Truck truck){
        trucks.add(truck);
    }
}
