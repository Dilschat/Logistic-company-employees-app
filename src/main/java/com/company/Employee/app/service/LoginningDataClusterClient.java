package com.company.Employee.app.service;

import org.springframework.context.annotation.Bean;

public interface LoginningDataClusterClient {
    /**
     *
     * @return string that contains access token
     */
    String login(String login, String password);
}
