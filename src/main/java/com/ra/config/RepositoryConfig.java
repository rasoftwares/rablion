package com.ra.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "com.ra.repository")
@EnableAutoConfiguration
@EntityScan(basePackages = {"com.ra.domain"})
public class RepositoryConfig {

}
