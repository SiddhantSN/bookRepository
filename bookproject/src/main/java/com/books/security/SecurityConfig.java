package com.books.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
	
	/*
	 * Security Plan : 
	 * Basic Authentication
	 * Personal Password for user
	 * JWT inbuilt generation
	 * JWT Third Party Authentication
	 * JWT with OAuth2
	 */

    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		
		http.csrf(t->t.disable()).authorizeHttpRequests(t->t.requestMatchers("/books/**").permitAll()
				.requestMatchers("/users/**").authenticated())
		.httpBasic(Customizer.withDefaults());
		
		return http.build();
    }
}
