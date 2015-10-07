package com.ra;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;

import com.ra.config.AppConfig;
import com.ra.server.ServletContainerCustomizer;

@SpringBootApplication
public class Application extends SpringBootServletInitializer {
	 
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(Application.class);
	}
	
    public static void main(String[] args) {
    	SpringApplication.run(new Object[]{ AppConfig.class, ServletContainerCustomizer.class}, args);
    }
}