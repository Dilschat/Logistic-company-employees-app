package com.company.Employee.app.connection.interfaces;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * Created by niyaz on 30.09.2018.
 */
public interface LoginRequest {

    @Headers({"Content-Type: application/json"})
    @POST("/login_auth")
    Call<LoginResponseData> login(@Body LoginData loginData);


    class LoginData{
        private String username, password;

        public LoginData(String username, String password) {
            this.username = username;
            this.password = password;
        }

        public LoginData() {
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }

    class LoginResponseData{
        private String token, error, role;


        public LoginResponseData() {
        }

        public LoginResponseData(String token, String error, String role) {
            this.token = token;
            this.error = error;
            this.role = role;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }

        public String getError() {
            return error;
        }

        public void setError(String error) {
            this.error = error;
        }

        public String getRole() {
            return role;
        }

        public void setRole(String role) {
            this.role = role;
        }
    }
}
