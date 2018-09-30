package com.company.Employee.app.service;

import com.company.Employee.app.model.LoginResponse;

public interface LoginningDataClusterClient {
    /**
     *
     * @return string that contains access token
     */
    LoginResponse login(String login, String password);
    LoginResponse login(String login);

}
