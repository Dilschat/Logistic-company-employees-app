package com.employee.app.Employee.app.service.interfaces;

import com.employee.app.Employee.app.model.DispatchedOrder;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;

public interface getDispatchedOrder {
    @Headers({"Content-Type: application/json"})
    @GET("/get_order_by_id")
    Call<getDispatchedOrder.Order> getOrder(@Body Integer id);

    public class Order {
        @SerializedName("orders")
        @Expose
        private DispatchedOrder order = null;
        @SerializedName("public/error")
        @Expose
        private String error;

        public DispatchedOrder getOrders() {
            return order;
        }

        public void setOrders(DispatchedOrder order) {
            this.order = order;
        }

        public String getError() {
            return error;
        }

        public void setError(String error) {
            this.error = error;
        }
    }
}
