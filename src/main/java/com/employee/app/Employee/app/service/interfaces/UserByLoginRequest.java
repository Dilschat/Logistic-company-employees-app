package com.employee.app.Employee.app.service.interfaces;


import retrofit2.Call;
import retrofit2.http.*;

public interface UserByLoginRequest {

    @Headers({"Content-Type: application/json"})
    @POST("/user_by_login")
    Call<UserByLoginRequest.UserInfo> userByLogin(@Body String login);

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