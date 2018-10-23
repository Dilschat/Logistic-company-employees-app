package com.employee.app.Employee.app.service.interfaces;

import com.employee.app.Employee.app.model.LoginRequest;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface Login {
    @Headers({"Content-Type: application/json"})
    @POST("/login")
    Call<Login.UserInfo> userByLogin(@Body LoginRequest login);

    public class UserInfo {
        private String password, role, error;

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getRole() {
            return role;
        }

        public void setRole(String role) {
            this.role = role;
        }

        public String getError() {
            return error;
        }

        public void setError(String error) {
            this.error = error;
        }
    }
}
