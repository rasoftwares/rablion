package com.ra;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.context.annotation.Configuration;

import com.ra.config.AppConfig;
import com.ra.server.ServletContainerCustomizer;

@SpringApplicationConfiguration
@Configuration
@EnableAutoConfiguration
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(new Object[]{ AppConfig.class, ServletContainerCustomizer.class}, args);
    }
}