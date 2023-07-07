package com.example.Employee.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import javax.sql.DataSource;
@Configuration
public class Config {
    //add support for jdbc
    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource) {
        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);
        jdbcUserDetailsManager.setUsersByUsernameQuery(
                "select user_id,password from users where user_id=?");
        jdbcUserDetailsManager.setAuthoritiesByUsernameQuery(
                "select user_id,role from roles where user_id=?");
        return jdbcUserDetailsManager;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(configurer ->
                configurer
                        .requestMatchers(HttpMethod.GET, "/view").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.GET, "/view").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.GET, "/view").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.GET, "/Employee/{id}/view").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.GET, "/Employee/{id}/view").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.POST, "/add").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/Employee/{id}/delete").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/Employee/{id}/delete").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.PUT, "/Employee/{id}/update").hasRole("ADMIN")
        );
        http.httpBasic(Customizer.withDefaults());
        http.csrf(csrf -> csrf.disable());
        return http.build();
    }
}