package com.allianzafrica.configuration;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EntityScan(basePackages = {"com.allianzafrica.model"})
@EnableJpaRepositories(basePackages = {"com.allianzafrica.repositories"})
@EnableTransactionManagement
public class RepositoryConfiguration {

}
