package com.employee.app.Employee.app.service.singletones;

import com.employee.app.Employee.app.model.Warehouse;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by niyaz on 01.11.2018.
 */
public class WarehousesSingleton {

    private static volatile WarehousesSingleton instance;
    private static volatile ArrayList<Warehouse> warehouses;
    private static final Object lock = new Object();

    private WarehousesSingleton() {}
    /*
     * something with synchronized
     * don't know why we need it
     * I copy pasted code from wikipedia
     * seems good
     */
    public static WarehousesSingleton getInstance() {
        WarehousesSingleton localInstance = instance;
        if (localInstance == null) {
            synchronized (lock) {
                localInstance = instance;
                if (localInstance == null) {
                    instance = localInstance = new WarehousesSingleton();
                    warehouses = new ArrayList<>();
                }
            }
        }
        return localInstance;
    }

    public ArrayList<Warehouse> getTrucks(){
        return warehouses;
    }

    public void addTruck(Warehouse truck){
        warehouses.add(truck);
    }

    public void setWarehouses(List<Warehouse> warehouses) {
        WarehousesSingleton.warehouses = new ArrayList<>(warehouses);
    }
}
