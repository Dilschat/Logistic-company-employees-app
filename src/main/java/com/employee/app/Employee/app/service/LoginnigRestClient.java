package com.employee.app.Employee.app.service;

import com.employee.app.Employee.app.model.LoginRequest;
import com.employee.app.Employee.app.model.LoginResponse;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class LoginnigRestClient implements LoginningDataClusterClient {
    @Override
    public LoginResponse login(LoginRequest loginRequest) throws IOException {
        return DataClusterCommunication.userByLogin(loginRequest.getLogin());
    }


}
