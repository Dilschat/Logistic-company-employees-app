package com.employee.app.Employee.app.service;

import com.employee.app.Employee.app.model.LoginResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class DataClusterUserDetailsService implements UserDetailsService {


    private LoginnigRestClient loginnigRestClient;

    @Autowired
    DataClusterUserDetailsService(LoginnigRestClient restClient){
        loginnigRestClient = restClient;
    }

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        LoginResponse userDataLoginResponse = null;
        try {
            userDataLoginResponse = loginnigRestClient.login(login);
        } catch (IOException e) {
            e.printStackTrace();
        }
        UserDetails details = User
                .withDefaultPasswordEncoder()
                .username(userDataLoginResponse.getUsername())
                .password(userDataLoginResponse.getPassword())
                .roles(userDataLoginResponse.getRole())
                .build();

        return details;
    }


}
