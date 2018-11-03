package com.employee.app.Employee.app.service.interfaces;

import com.employee.app.Employee.app.model.DispatchedOrder;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

import java.util.List;

public interface GetDispatchedOrders {
    @Headers({"Content-Type: application/json"})
    @GET("/orders")
    Call<OrderList> getOrders();
    public class OrderList {

        @SerializedName("orders")
        @Expose
        private List<DispatchedOrder> orders = null;
        @SerializedName("public/error")
        @Expose
        private String error;

        public List<DispatchedOrder> getOrders() {
            return orders;
        }

        public void setOrders(List<DispatchedOrder> orders) {
            this.orders = orders;
        }

        public String getError() {
            return error;
        }

        public void setError(String error) {
            this.error = error;
        }

    }


}
