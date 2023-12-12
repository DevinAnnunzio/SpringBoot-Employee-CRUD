package com.annunzio.employeecrud.security;

import com.annunzio.employeecrud.entity.Employee;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class DemoSecurityConfig {

    @Bean
    public InMemoryUserDetailsManager userDetailsManager(){
        UserDetails john = User.builder()
                .username("john")
                .password("{noop}john123")
                .roles("EMPLOYEE")
                .build();

        UserDetails mike = User.builder()
                .username("mike")
                .password("{noop}mike123")
                .roles("EMPLOYEE", "MANAGER")
                .build();


        UserDetails bob = User.builder()
                .username("bob")
                .password("{noop}bob123")
                .roles("EMPLOYEE", "MANAGER", "ADMIN")
                .build();

        return new InMemoryUserDetailsManager(john, mike, bob);

    }

}
