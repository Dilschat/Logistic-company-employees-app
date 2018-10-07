package com.employee.app.Employee.app.model;


import com.employee.app.Employee.app.service.helpers.DateHelper;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.text.ParseException;
import java.util.Comparator;
import java.util.Date;

/**
 * Created by niyaz on 06.10.2018.
 */
public class Order {

    // really valuable info for server
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("timestamp")
    @Expose
    private String timestamp;
    @SerializedName("delivery_type")
    @Expose
    private String delivery_type; //normal or express

    private String sender_firstname, sender_lastname,
            sender_country, sender_region, sender_city, sender_street, sender_building_number,
            sender_additional_info;
    private String receiver_firstname, receiver_lastname,
            receiver_country, receiver_region, receiver_city, receiver_street, receiver_building_number,
            receiver_additional_info;

    private String package_height, package_length, package_width, package_weight;
    private String receiver_number, sender_number; // additional info

    public static Comparator<Order> getComparator() {
        return new Comparator<Order>() {
            @Override
            public int compare(Order o1, Order o2) {
                try {
                    if (o1.getDelivery_type().equals(o2.getDelivery_type())) {
                        Date d1 = DateHelper.getTime(o1.getTimestamp());
                        Date d2 = DateHelper.getTime(o2.getTimestamp());
                        return d1.compareTo(d2);
                    } else {
                        if(o1.getDelivery_type().equals("express"))
                            return 1;
                        return -1;
                    }
                } catch (ParseException e) {
                    return 0;
                }
            }
        };
    }





    public String getSender_firstname() {
        return sender_firstname;
    }

    public void setSender_firstname(String sender_firstname) {
        this.sender_firstname = sender_firstname;
    }

    public String getSender_lastname() {
        return sender_lastname;
    }

    public void setSender_lastname(String sender_lastname) {
        this.sender_lastname = sender_lastname;
    }

    public String getSender_country() {
        return sender_country;
    }

    public void setSender_country(String sender_country) {
        this.sender_country = sender_country;
    }

    public String getSender_region() {
        return sender_region;
    }

    public void setSender_region(String sender_region) {
        this.sender_region = sender_region;
    }

    public String getSender_city() {
        return sender_city;
    }

    public void setSender_city(String sender_city) {
        this.sender_city = sender_city;
    }

    public String getSender_street() {
        return sender_street;
    }

    public void setSender_street(String sender_street) {
        this.sender_street = sender_street;
    }

    public String getSender_building_number() {
        return sender_building_number;
    }

    public void setSender_building_number(String sender_building_number) {
        this.sender_building_number = sender_building_number;
    }

    public String getSender_additional_info() {
        return sender_additional_info;
    }

    public void setSender_additional_info(String sender_additional_info) {
        this.sender_additional_info = sender_additional_info;
    }

    public String getReceiver_firstname() {
        return receiver_firstname;
    }

    public void setReceiver_firstname(String receiver_firstname) {
        this.receiver_firstname = receiver_firstname;
    }

    public String getReceiver_lastname() {
        return receiver_lastname;
    }

    public void setReceiver_lastname(String receiver_lastname) {
        this.receiver_lastname = receiver_lastname;
    }

    public String getReceiver_country() {
        return receiver_country;
    }

    public void setReceiver_country(String receiver_country) {
        this.receiver_country = receiver_country;
    }

    public String getReceiver_region() {
        return receiver_region;
    }

    public void setReceiver_region(String receiver_region) {
        this.receiver_region = receiver_region;
    }

    public String getReceiver_city() {
        return receiver_city;
    }

    public void setReceiver_city(String receiver_city) {
        this.receiver_city = receiver_city;
    }

    public String getReceiver_street() {
        return receiver_street;
    }

    public void setReceiver_street(String receiver_street) {
        this.receiver_street = receiver_street;
    }

    public String getReceiver_building_number() {
        return receiver_building_number;
    }

    public void setReceiver_building_number(String receiver_building_number) {
        this.receiver_building_number = receiver_building_number;
    }

    public String getReceiver_additional_info() {
        return receiver_additional_info;
    }

    public void setReceiver_additional_info(String receiver_additional_info) {
        this.receiver_additional_info = receiver_additional_info;
    }

    public String getPackage_height() {
        return package_height;
    }

    public void setPackage_height(String package_height) {
        this.package_height = package_height;
    }

    public String getPackage_length() {
        return package_length;
    }

    public void setPackage_length(String package_length) {
        this.package_length = package_length;
    }

    public String getPackage_width() {
        return package_width;
    }

    public void setPackage_width(String package_width) {
        this.package_width = package_width;
    }

    public String getPackage_weight() {
        return package_weight;
    }

    public void setPackage_weight(String package_weight) {
        this.package_weight = package_weight;
    }

    public String getDelivery_type() {
        return delivery_type;
    }

    public void setDelivery_type(String delivery_type) {
        this.delivery_type = delivery_type;
    }

    public String getReceiver_number() {
        return receiver_number;
    }

    public void setReceiver_number(String receiver_number) {
        this.receiver_number = receiver_number;
    }

    public String getSender_number() {
        return sender_number;
    }

    public void setSender_number(String sender_number) {
        this.sender_number = sender_number;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}
