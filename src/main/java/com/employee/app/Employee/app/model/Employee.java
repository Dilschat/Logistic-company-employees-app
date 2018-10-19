package com.employee.app.Employee.app.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by niyaz on 17.10.2018.
 */
public class Employee {

    @SerializedName("login")
    @Expose
    private String login;
    @SerializedName("password_hash")
    @Expose
    private String passwordHash;
    @SerializedName("role")
    @Expose
    private String role;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

}