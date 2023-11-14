package org.jesus.jesusspring.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = {"org.jesus.jesusspring.**.entity"})
@Configuration
public class JpaConfig {
}
