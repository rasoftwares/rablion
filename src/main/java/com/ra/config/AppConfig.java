package com.ra.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
 
@Configuration
@ComponentScan("com.ra.config")
public class AppConfig extends WebMvcConfigurerAdapter {
 
	@Override
	public void addCorsMappings(CorsRegistry registry) {
 
		registry.addMapping("/**")
		.allowedOrigins("http://localhost:8080")
		.allowedMethods("POST", "GET", "PUT", "DELETE")
		.allowedHeaders("Content-Type")
		.exposedHeaders("header-1")
		.allowCredentials(false)
		.maxAge(6000);
	}
}