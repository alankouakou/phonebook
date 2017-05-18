package net.ycod3r.configuration;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EntityScan(basePackages = {"net.ycod3r.model"})
@EnableJpaRepositories(basePackages = {"net.ycod3r.repositories"})
@EnableTransactionManagement
public class RepositoryConfiguration {

}
