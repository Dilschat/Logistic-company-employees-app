package com.employee.app.Employee.app.service;

import com.employee.app.Employee.app.model.LoginResponse;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class LoginnigRestClient implements LoginningDataClusterClient {
    @Override
    public LoginResponse login(String login, String password) throws IOException {
        return DataClusterCommunication.userByLogin(login);
    }

    @Override
    public LoginResponse login(String login) throws IOException {
        return DataClusterCommunication.userByLogin(login);
    }
}
