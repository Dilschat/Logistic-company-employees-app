package com.employee.app.Employee.app.service.daemons;

import com.employee.app.Employee.app.model.Warehouse;
import com.employee.app.Employee.app.service.DataClusterCommunication;
import com.employee.app.Employee.app.service.singletones.WarehousesSingleton;

import java.io.IOException;
import java.util.List;

/**
 * Created by niyaz on 01.11.2018.
 */
public class WarehousesManager {
    private static Thread thread;

    public static void run(){
        thread = new Thread(new WarehousesRefresherRunnable());
        thread.setDaemon(true); // more demon that Malebolgia
        thread.start();
    }

    public static class WarehousesRefresherRunnable implements Runnable {

        private WarehousesSingleton warehousesSingleton;

        WarehousesRefresherRunnable(){
            warehousesSingleton = WarehousesSingleton.getInstance();
        }

        @Override
        public void run() {
            synchronized (this) {
                while (true) {
                    try {
                        List<Warehouse> list = DataClusterCommunication.getWarehousesList();
                        if (list != null) {
                            warehousesSingleton.setWarehouses(list);
                        }
                        wait(600000);
                    } catch (InterruptedException e) {
                        e.printStackTrace(); // shouldn't happen "WHAT ARE YOU DOING IN MY SWAMP?"
                    } catch (IOException e) {
                        //do nothing
                    }
                }
            }
        }
    }
}
