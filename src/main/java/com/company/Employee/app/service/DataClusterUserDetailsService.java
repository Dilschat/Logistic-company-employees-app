package com.company.Employee.app.service;

import com.company.Employee.app.model.LoginResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class DataClusterUserDetailsService implements UserDetailsService {

    @Autowired
    LoginnigRestClient loginnigRestClient;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        LoginResponse userDataLoginResponse = loginnigRestClient.login(login);
        return new EmployeeDetailsService(userDataLoginResponse);
    }
}
