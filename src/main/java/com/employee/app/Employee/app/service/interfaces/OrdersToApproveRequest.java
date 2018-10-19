package com.employee.app.Employee.app.service.interfaces;

import com.employee.app.Employee.app.model.Order;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by niyaz on 06.10.2018.
 */
public interface OrdersToApproveRequest {

    @Headers({"Content-Type: application/json"})
    @GET("/orders_to_approve")
    Call<OrdersToApproveRequest.OrdersToApproveResponse> ordersToApprove();


    class OrdersToApproveResponse {
        @SerializedName("orders")
        @Expose
        private List<Order> orders = null;

        public List<Order> getOrders() {
            return orders;
        }

        public void setOrders(List<Order> orders) {
            this.orders = orders;
        }

    }

    public class Address {

        @SerializedName("additional_info")
        @Expose
        private String additionalInfo;
        @SerializedName("building")
        @Expose
        private String building;
        @SerializedName("city")
        @Expose
        private String city;
        @SerializedName("country")
        @Expose
        private String country;
        @SerializedName("region")
        @Expose
        private String region;
        @SerializedName("street")
        @Expose
        private String street;

        public String getAdditionalInfo() {
            return additionalInfo;
        }

        public void setAdditionalInfo(String additionalInfo) {
            this.additionalInfo = additionalInfo;
        }

        public String getBuilding() {
            return building;
        }

        public void setBuilding(String building) {
            this.building = building;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        public String getRegion() {
            return region;
        }

        public void setRegion(String region) {
            this.region = region;
        }

        public String getStreet() {
            return street;
        }

        public void setStreet(String street) {
            this.street = street;
        }

    }

    public class Receiver {

        @SerializedName("address")
        @Expose
        private Address address;
        @SerializedName("name")
        @Expose
        private String name;
        @SerializedName("phone_number")
        @Expose
        private String phoneNumber;
        @SerializedName("surname")
        @Expose
        private String surname;

        public Address getAddress() {
            return address;
        }

        public void setAddress(Address address) {
            this.address = address;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPhoneNumber() {
            return phoneNumber;
        }

        public void setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
        }

        public String getSurname() {
            return surname;
        }

        public void setSurname(String surname) {
            this.surname = surname;
        }

    }

    public class Sender {

        @SerializedName("address")
        @Expose
        private Address address;
        @SerializedName("name")
        @Expose
        private String name;
        @SerializedName("phone_number")
        @Expose
        private String phoneNumber;
        @SerializedName("surname")
        @Expose
        private String surname;

        public Address getAddress() {
            return address;
        }

        public void setAddress(Address address) {
            this.address = address;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPhoneNumber() {
            return phoneNumber;
        }

        public void setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
        }

        public String getSurname() {
            return surname;
        }

        public void setSurname(String surname) {
            this.surname = surname;
        }

    }
}
