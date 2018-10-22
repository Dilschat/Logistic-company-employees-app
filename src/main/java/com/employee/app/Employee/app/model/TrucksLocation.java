package com.employee.app.Employee.app.model;

import com.employee.app.Employee.app.service.singletones.TruckSingleton;

import java.util.ArrayList;

/**
 * Created by niyaz on 21.10.2018.
 */
public class TrucksLocation {

    private final String type = "truck_locations";

    private ArrayList<Truck> trucks;

    public ArrayList<Truck> getTrucks() {
        return trucks;
    }

    public void setTrucks(ArrayList<Truck> trucks) {
        this.trucks = trucks;
    }

    public TrucksLocation() {
        trucks = TruckSingleton.getInstance().getTrucks();
    }
}
