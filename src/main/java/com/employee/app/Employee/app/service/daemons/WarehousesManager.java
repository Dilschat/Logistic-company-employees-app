package com.employee.app.Employee.app.service.daemons;

import com.employee.app.Employee.app.model.Warehouse;
import com.employee.app.Employee.app.service.DataClusterCommunication;
import com.employee.app.Employee.app.service.helpers.GeoHelper;
import com.employee.app.Employee.app.service.interfaces.AddressGeocodingRequest;
import com.employee.app.Employee.app.service.singletones.WarehousesSingleton;

import java.io.IOException;
import java.util.LinkedList;
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
                        List<Warehouse> newWarehouses = DataClusterCommunication.getWarehousesList();
                        List<Warehouse> resultingList = new LinkedList<>();
                        // if some of the warehouses have undecodable coordinates, we will ignore it
                        // that why we introduce resultingList, we will store only valid warehouses
                        if (newWarehouses != null) {
                            warehousesSingleton.setWarehouses(newWarehouses);


                            for (Warehouse warehouse : newWarehouses) {

                                AddressGeocodingRequest.Position position =
                                        GeoHelper.getCoordinatesByAddress(warehouse.getFullAddress());

                                if(position != null) {
                                    warehouse.setLatitude(position.getLat());
                                    warehouse.setLongitude(position.getLon());

                                    resultingList.add(warehouse);
                                }
                            }

                            WarehousesSingleton singleton = WarehousesSingleton.getInstance();
                            singleton.setWarehouses(resultingList);

                            wait(3600000); // in case of request success we wait 1 hour
                        } else {
                            wait(30000); // in case of request failure we wait 5 minutes
                        }
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
