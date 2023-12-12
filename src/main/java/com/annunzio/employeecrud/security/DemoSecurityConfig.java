package com.annunzio.employeecrud.security;

import com.annunzio.employeecrud.entity.Employee;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

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

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(configurer ->
                configurer
                        .requestMatchers(HttpMethod.GET, "/company/workers").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.GET, "/company/workers/**").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.POST, "/company/workers").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.PUT, "/company/workers").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.DELETE, "/company/workers/**").hasRole("ADMIN")
                );
        //HTTP basic authentication
        http.httpBasic(Customizer.withDefaults());
        //Disable CSRF since it is stateless API
        http.csrf(csrf -> csrf.disable());

        return http.build();
    }


}
