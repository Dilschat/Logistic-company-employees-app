package com.company.Employee.app.config;

import com.company.Employee.app.service.DataClusterUserDetailsService;
import com.company.Employee.app.service.LoginningDataClusterClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests().antMatchers("/loginFailed").permitAll()
                .and()
                .authorizeRequests().antMatchers("/**").authenticated()
                .and()
                .formLogin()
                .loginPage("/login").successForwardUrl("/loginSuccess")
                .permitAll().and().authenticationProvider(new CustomAuthentication());
    }



}
