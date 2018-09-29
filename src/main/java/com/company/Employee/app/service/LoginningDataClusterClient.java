package com.company.Employee.app.service;

import com.company.Employee.app.model.Response;
import org.springframework.context.annotation.Bean;

public interface LoginningDataClusterClient {
    /**
     *
     * @return string that contains access token
     */
    Response login(String login, String password);
    Response login(String login);

}
