package com.employee.app.Employee.app.service;

import com.employee.app.Employee.app.model.Response;
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
        Response userDataResponse = null;
        try {
            userDataResponse = loginnigRestClient.login(login);
        } catch (IOException e) {
            e.printStackTrace();
        }
        UserDetails details = User
                .withDefaultPasswordEncoder()
                .username(userDataResponse.getUsername())
                .password(userDataResponse.getPassword())
                .roles(userDataResponse.getRole())
                .build();

        return details;
    }


}
