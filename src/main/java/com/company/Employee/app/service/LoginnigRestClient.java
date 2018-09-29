package com.company.Employee.app.service;

import com.company.Employee.app.model.Response;
import org.springframework.stereotype.Component;

@Component
public class LoginnigRestClient implements LoginningDataClusterClient {
    @Override
    public Response login(String login, String password) {
        return null;
    }

    @Override
    public Response login(String login) {
        return null;
    }
}
