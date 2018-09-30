package com.company.Employee.app.service;

import com.company.Employee.app.model.LoginResponse;
import org.springframework.stereotype.Component;

@Component
public class LoginnigRestClient implements LoginningDataClusterClient {

    @Override
    public LoginResponse login(String login, String password) {
        return null;
    }

    @Override
    public LoginResponse login(String login) {
        return null;
    }
}
