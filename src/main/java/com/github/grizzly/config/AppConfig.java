package com.github.grizzly.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "com.github.grizzly.repository")
@EntityScan(basePackages = "com.github.grizzly.entity")
public class AppConfig {
}
