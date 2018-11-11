package com.employee.app.Employee.app.service.interfaces;

import com.employee.app.Employee.app.model.RequestError;
import com.employee.app.Employee.app.model.Order;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * Created by niyaz on 06.10.2018.
 */
public interface AddOrder {

    @Headers({"Content-Type: application/json"})
    @POST("/add_order")
    Call<OrderCreationResponse> addOrder(@Body Order order);

    public class OrderCreationResponse{
        @Expose
        @SerializedName("order_id")
        public int orderId;

        public int getOrderId() {
            return orderId;
        }

        public void setOrderId(int orderId) {
            this.orderId = orderId;
        }
    }
}
