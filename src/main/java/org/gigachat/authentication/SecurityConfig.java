package org.gigachat.authentication;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(
                authorize -> authorize
                        .requestMatchers("/health", "/api/v1/users/register").permitAll()
                        .anyRequest().authenticated()
        ).formLogin(
                formLogin ->
                        formLogin.loginProcessingUrl("/api/v1/login").permitAll()

        ).logout(
                logout ->
                        logout.logoutUrl("/api/v1/logout").permitAll()
        )
        ;

        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        return username -> {
            // Placeholder user details; replace with actual user retrieval logic
            return org.springframework.security.core.userdetails.User
                    .withUsername("user")
                    .password("{noop}password") // {noop} indicates no password encoding
                    .roles("USER")
                    .build();
        };
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
