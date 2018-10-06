package com.employee.app.Employee.app.daemons;

import com.employee.app.Employee.app.model.Order;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.concurrent.PriorityBlockingQueue;

/**
 * Created by niyaz on 06.10.2018.
 */
public class OrdersToApproveQueue {
    private static volatile OrdersToApproveQueue instance;
    private static volatile PriorityBlockingQueue<Order> orders;
    private static final Object lock = new Object();
    private static volatile HashSet<String> contains;
    /* every time new order is added to the queue
    id of this order will be added to set
    so no order with same id will not added to the queue
    for every getOrder id of order will be removed from set */

    /**
     * deletes order from queue and returns it
     * @return null if queue is empty
     */
    public Order getOrder(){
        synchronized (lock){
            Order res = orders.poll();
            if (res == null)
                return null;
            return res;
        }
    }

    /**
     * tries to add new order in queue
     * guarantees that order with id that already is present in queue will not be added
     * @param order
     * @return true in case of success
     */
    public boolean putOrder(Order order){
        synchronized (lock){
            if(! contains.contains(order.getId())) {
                contains.add(order.getId());
                return orders.offer(order);
            }
            return false;
        }
    }


    private OrdersToApproveQueue() {}

    /*
     * something with synchronized
     * don't know why we need it
     * I copy pasted code from wikipedia
     * seems good
     */
    public static OrdersToApproveQueue getInstance() {
        OrdersToApproveQueue localInstance = instance;
        if (localInstance == null) {
            synchronized (OrdersToApproveQueue.class) {
                localInstance = instance;
                if (localInstance == null) {
                    instance = localInstance = new OrdersToApproveQueue();
                    orders = new PriorityBlockingQueue<>(10, Order.getComparator());
                    contains = new HashSet<>();
                }
            }
        }
        return localInstance;
    }
}
