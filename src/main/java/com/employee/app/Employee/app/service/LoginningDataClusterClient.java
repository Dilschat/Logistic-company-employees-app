package com.employee.app.Employee.app.service;


import com.employee.app.Employee.app.model.LoginRequest;
import com.employee.app.Employee.app.model.LoginResponse;

import java.io.IOException;

public interface LoginningDataClusterClient {
    /**
     *
     * @return string that contains access token
     */
    LoginResponse login(LoginRequest request) throws IOException;

}
