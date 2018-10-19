package com.employee.app.Employee.app.websocket;

import java.util.Random;

/**
 * Created by niyaz on 19.10.2018.
 */
public class TruckLocation {

    private int id;
    private double x,y;
    private double minX = 55.745000, maxX = 55.757000;
    private double maxY = 48.748000, minY = 48.763000;

    public TruckLocation(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void generateCoordinates(){
        Random rn = new Random();
        x = minX + (maxX - minX) * rn.nextDouble();
        y = minY + (maxY - minY) * rn.nextDouble();
    }
}
