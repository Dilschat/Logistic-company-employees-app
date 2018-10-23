package com.employee.app.Employee.app.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LoginRequest {
    @SerializedName("login")
    @Expose
    private String login;
    @SerializedName("password_hash")
    @Expose
    private String password_hash;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword_hash() {
        return password_hash;
    }

    public void setPassword_hash(String password_hash) {
        this.password_hash = password_hash;
    }
}
