package com.employee.app.Employee.app.service;


import com.employee.app.Employee.app.model.Response;

import java.io.IOException;

public interface LoginningDataClusterClient {
    /**
     *
     * @return string that contains access token
     */
    Response login(String login, String password) throws IOException;
    Response login(String login) throws IOException;

}
