package com.employee.app.Employee.app.service.interfaces;

import com.employee.app.Employee.app.model.Employee;
import com.employee.app.Employee.app.model.RequestError;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * Created by niyaz on 17.10.2018.
 */
public interface RegisterNewEmployee {

    @Headers({"Content-Type: application/json"})
    @POST("/register_new_employee")
    Call<RequestError> registerNewEmployee(@Body Employee new_employee);
}
