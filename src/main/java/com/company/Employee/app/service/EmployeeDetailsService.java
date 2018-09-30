package com.company.Employee.app.service;

import com.company.Employee.app.model.LoginResponse;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

public class EmployeeDetailsService implements UserDetails {
// TODO finish implementing remaining methods
    private String userName;
    private String password;

    EmployeeDetailsService(LoginResponse loginResponse){
        userName = loginResponse.getUsername();
        password = loginResponse.getPassword();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
