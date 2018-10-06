package com.employee.app.Employee.app.daemons;

import com.employee.app.Employee.app.model.Order;
import com.employee.app.Employee.app.service.DataClusterCommunication;

import java.io.IOException;
import java.util.List;

/**
 * Created by niyaz on 06.10.2018.
 */
public class OrdersToApproveManager {


    public void startOrdersToApproveDaemon(){
        Thread thread = new Thread(new OrdersToApproveManager.OrdersToApproveRunnable());
        thread.setDaemon(true); // more demon that Malebolgia
        thread.start();
    }

    public class OrdersToApproveRunnable implements Runnable {

        private OrdersToApproveQueue queue;

        OrdersToApproveRunnable(){
            queue = OrdersToApproveQueue.getInstance();
        }

        @Override
        public void run() {
            boolean personReadingThisCode = true;
            while (personReadingThisCode) {
                synchronized (this) {
                    try {
                        wait(5000);
                        List<Order> orders = DataClusterCommunication.getOrderToApprove();
                        if (orders != null) {
                            for (Order order : orders) {
                                queue.putOrder(order);
                            }
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
