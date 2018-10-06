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

        @SerializedName("timestamp")
        @Expose
        private String timestamp;
        @SerializedName("orders")
        @Expose
        private List<Order> orders = null;

        public String getTimestamp() {
            return timestamp;
        }

        public void setTimestamp(String timestamp) {
            this.timestamp = timestamp;
        }

        public List<Order> getOrders() {
            return orders;
        }

        public void setOrders(List<Order> orders) {
            this.orders = orders;
        }

    }
}
