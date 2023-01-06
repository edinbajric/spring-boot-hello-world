package com.task1.springboothelloworld.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests((requests) -> requests.antMatchers("/api/db/admin").hasRole("ADMIN").antMatchers("/", "/home").permitAll().anyRequest().authenticated())

                .formLogin((form) -> form.loginPage("/login").permitAll()).logout(LogoutConfigurer::permitAll);
        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails user = User.withDefaultPasswordEncoder().username("user").password("pass").roles("USER").build();
        UserDetails admin = User.withDefaultPasswordEncoder().username("admin").password("pass").roles("ADMIN").build();

        return new InMemoryUserDetailsManager(user, admin);
    }
}
