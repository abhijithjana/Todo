package com.project.TodoList.security;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import jakarta.servlet.http.HttpServletResponse;

/**
 * 
 */
@Configuration
public class Springsecurityconfig {

	@Bean
	public PasswordEncoder passwordencoder() {
		return new BCryptPasswordEncoder();
		
	}
	
	@Bean
	public InMemoryUserDetailsManager createuserdetailse() {
		UserDetails userdetails=User.builder().passwordEncoder(password->passwordencoder().encode(password)).username("abhi").password("1234").roles("ADMIN","USER").build();
		return new InMemoryUserDetailsManager(userdetails);
	}
	
	@Bean
	public SecurityFilterChain filterchain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests(auth->auth.anyRequest().authenticated());
		http.formLogin(Customizer.withDefaults());
		http.csrf(t ->t.disable());
		http.headers((header)->header.frameOptions((frameOptions) -> frameOptions.disable()));
		
		return http.build();
	}
}
