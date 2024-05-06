package com.cts.rentPlay.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

public class SecurityConfig {

//	@Bean
//	public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
//
//		httpSecurity.csrf(csrfConfig->csrfConfig.disable())
//		.authorizeHttpRequests(auth->auth
//				.requestMatchers(HttpMethod.OPTIONS , "/**").permitAll()
//				.requestMatchers("/**").permitAll()
//			.and().formLogin()
//			.and().httpBasic()
//				
//				);
//				
////		.exceptionHandling(ex->ex.authenticationEntryPoint(authenticationEntryPoint))
////		.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
////		;
////		httpSecurity.addFilterBefore(authfFilter, UsernamePasswordAuthenticationFilter.class);
////		
//	
//		return httpSecurity.build();
//	}
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

		
		 http.csrf((csrf) -> csrf.disable())
         .authorizeHttpRequests((requests)->requests
//        		 .requestMatchers(HttpMethod.OPTIONS , "/**").permitAll()
 				.requestMatchers("/api/users/register").permitAll()
 				.anyRequest().permitAll())
         .formLogin(Customizer.withDefaults())
         .httpBasic(Customizer.withDefaults());
	
		return http.build();
	}
}
