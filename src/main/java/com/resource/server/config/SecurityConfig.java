package com.resource.server.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.oauth2.server.resource.OAuth2ResourceServerConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
	
	@Value("${jwks.uri}")
	private String jwksUri;
	
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		
		http.oauth2ResourceServer(
		        r -> r.jwt().jwkSetUri(jwksUri)
		           
		    );

		    http.authorizeHttpRequests().anyRequest().authenticated();
		    return http.build();
		
		
	}
	

}
