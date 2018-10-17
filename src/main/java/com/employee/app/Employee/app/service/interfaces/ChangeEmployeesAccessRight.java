package com.employee.app.Employee.app.service.interfaces;

import com.employee.app.Employee.app.model.RequestError;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * Created by niyaz on 17.10.2018.
 */
public interface ChangeEmployeesAccessRight {


    @Headers({"Content-Type: application/json"})
    @POST("/change_employee_access_rights")
    Call<RequestError> changeRights(@Body String login, @Body String role);
}
