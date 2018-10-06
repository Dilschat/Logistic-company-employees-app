package com.employee.app.Employee.app.service;


import com.employee.app.Employee.app.model.Response;
import org.junit.Test;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.IOException;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class DataClusterUserDetailsServiceTest {



    @Test
    public void loadUserByUsername() throws IOException {
        LoginnigRestClient client = mock(LoginnigRestClient.class);
        when(client.login("user")).thenReturn(new Response("user","password","USER", null));
        DataClusterUserDetailsService userDetailsService = new DataClusterUserDetailsService(client);
        UserDetails retrievedDetails = userDetailsService.loadUserByUsername("user");
        UserDetails expectedDetails =       User
                .withDefaultPasswordEncoder()
                .username("user")
                .password("password")
                .roles("USER")
                .build();
        assertEquals(retrievedDetails,expectedDetails);
    }

//    @Test
//    public void cantLoadUserByUsername() {
//        LoginnigRestClient client = mock(LoginnigRestClient.class);
//        when(client.login("user")).thenReturn(new Response("user","password","USER", null));
//        DataClusterUserDetailsService userDetailsService = new DataClusterUserDetailsService(client);
//        UserDetails retrievedDetails = userDetailsService.loadUserByUsername("user1");
//        UserDetails expectedDetails =       User
//                .withDefaultPasswordEncoder()
//                .username("user")
//                .password("password")
//                .roles("USER")
//                .build();
//        assertNotEquals(retrievedDetails,expectedDetails);
//    }
}
