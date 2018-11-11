package com.employee.app.Employee.app.model;


import com.employee.app.Employee.app.service.interfaces.OrdersToApproveRequest;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Comparator;

public class Order {

    @SerializedName("attached_notes")
    @Expose
    private String attachedNotes;
    @SerializedName("delivery_type")
    @Expose
    private String deliveryType;
    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("order_status")
    @Expose
    private String orderStatus;
    @SerializedName("pickup_type")
    @Expose
    private String pickupType;
    @SerializedName("receiver")
    @Expose
    private OrdersToApproveRequest.Receiver receiver;
    @SerializedName("sender")
    @Expose
    private OrdersToApproveRequest.Sender sender;

    /**
     * stays here for a while
     * @return
     */
    public static Comparator<Order> getComparator() {
        return new Comparator<Order>() {
            @Override
            public int compare(Order o1, Order o2) {
                if (o1.getDeliveryType().equals(o2.getDeliveryType())) {
                    //Date d1 = DateHelper.getTime(o1.getTimestamp());
                    //Date d2 = DateHelper.getTime(o2.getTimestamp());
                    return Integer.compare(o1.getId(), o2.getId());
                } else {
                    if(o2.getDeliveryType().equals("Ordinary"))
                        return 1;
                    return -1;
                }
            }
        };
    }

    public String getAttachedNotes() {
        return attachedNotes;
    }

    public void setAttachedNotes(String attachedNotes) {
        this.attachedNotes = attachedNotes;
    }

    public String getDeliveryType() {
        return deliveryType;
    }

    public void setDeliveryType(String deliveryType) {
        this.deliveryType = deliveryType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getPickupType() {
        return pickupType;
    }

    public void setPickupType(String pickupType) {
        this.pickupType = pickupType;
    }

    public OrdersToApproveRequest.Receiver getReceiver() {
        return receiver;
    }

    public void setReceiver(OrdersToApproveRequest.Receiver receiver) {
        this.receiver = receiver;
    }

    public OrdersToApproveRequest.Sender getSender() {
        return sender;
    }

    public void setSender(OrdersToApproveRequest.Sender sender) {
        this.sender = sender;
    }

}