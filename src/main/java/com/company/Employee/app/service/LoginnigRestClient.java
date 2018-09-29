package com.company.Employee.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class LoginnigRestClient implements LoginningDataClusterClient {
    @Override
    public String login(String login, String password) {
        return null;
    }
}
