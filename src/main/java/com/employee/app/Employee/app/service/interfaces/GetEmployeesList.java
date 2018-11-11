package com.employee.app.Employee.app.service.interfaces;

import com.employee.app.Employee.app.model.Employee;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

import java.util.List;

/**
 * Created by niyaz on 17.10.2018.
 */
public interface GetEmployeesList {

    @Headers({"Content-Type: application/json"})
    @GET("/get_employees_list")
    Call<EmployeesList> getEmployeesList();

    public class EmployeesList {

        @SerializedName("employees")
        @Expose
        private List<Employee> employees = null;
        @SerializedName("public/error")
        @Expose
        private String error;

        public List<Employee> getEmployees() {
            return employees;
        }

        public void setEmployees(List<Employee> employees) {
            this.employees = employees;
        }

        public String getError() {
            return error;
        }

        public void setError(String error) {
            this.error = error;
        }

    }

}
