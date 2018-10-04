package com.company.Employee.app.connection.interfaces;

import retrofit2.Call;
import retrofit2.http.*;

public interface UserByLogin {

    @Headers({"Content-Type: application/json"})
    @GET("/user_by_login")
    Call<UserByLogin.UserInfo> userByLogin(@Query("login") String login);

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
