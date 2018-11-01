package com.employee.app.Employee.app.service.daemons;

import com.employee.app.Employee.app.model.Order;
import com.employee.app.Employee.app.service.DataClusterCommunication;
import com.employee.app.Employee.app.service.singletones.OrdersToApproveQueue;

import java.io.IOException;
import java.util.List;

import static java.lang.Thread.sleep;

public class OrdersToApproveManager {

    private static Thread thread;

    public static void run(){
        thread = new Thread(new OrdersToApproveManager.OrdersToApproveRunnable());
        thread.setDaemon(true); // more demon that Malebolgia
        thread.start();
    }

    public static class OrdersToApproveRunnable implements Runnable {

        private OrdersToApproveQueue queue;

        OrdersToApproveRunnable(){
            queue = OrdersToApproveQueue.getInstance();
        }

        @Override
        public void run() {
            synchronized (this) {
                while (true) {
                    try {
                        if(queue.canAdd()) {
                            List<Order> orders = DataClusterCommunication.getOrderToApprove();

                            if (orders != null) {
                                for (Order order : orders) {
                                    queue.putOrder(order);
                                }
                            }
                        }
                        wait(5000);
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
