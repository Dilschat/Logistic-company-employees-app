package com.employee.app.Employee.app.config;

import com.employee.app.Employee.app.service.DataClusterUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;


@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

     private UserDetailsService employeesDetailsService;

     @Autowired
     WebSecurityConfig(DataClusterUserDetailsService detailsService){
         employeesDetailsService = detailsService;
     }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        http
//                .csrf().disable()
//                .userDetailsService(employeesDetailsService)
//                .authorizeRequests()
//                .anyRequest().authenticated().antMatchers("/map")
//                .hasRole("TopManager").anyRequest().hasRole("ControlOperator").anyRequest().authenticated()
//                .and()
//                .formLogin()
//                .defaultSuccessUrl("/main",true)
//                .loginPage("/login")
//                .permitAll()
//                .and()
//                .logout()
//                .permitAll()
//        ;

    }
    @Override
    public void configure(WebSecurity web) {
        web.ignoring().antMatchers("/webjars/**","/css/**", "/js/**", "/thymeleaf/**", "/static/**");
    }


}