package com.employee.app.Employee.app.service.interfaces;

import com.employee.app.Employee.app.model.RequestError;
import com.employee.app.Employee.app.model.Order;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * Created by niyaz on 06.10.2018.
 */
public interface ApproveOrder {

    @Headers({"Content-Type: application/json"})
    @POST("/approve_order")
    Call<RequestError> approveOrder(@Body Order order);
}
