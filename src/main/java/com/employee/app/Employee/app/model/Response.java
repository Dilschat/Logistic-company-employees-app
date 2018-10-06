package com.employee.app.Employee.app.model;

public class Response {
    private String username;
    private String password;
    private String role;
    private String error;

    public Response(String username, String password, String role, String error) {
        this.username = username;
        this.password = password;
        this.role = role;
        this.error = error;
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
