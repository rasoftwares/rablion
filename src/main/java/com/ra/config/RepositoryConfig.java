package com.ra.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "com.ps.repository")
@EnableAutoConfiguration
@EntityScan(basePackages = {"com.ps.domain"})
public class RepositoryConfig {

}
