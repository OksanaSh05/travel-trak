package com.dyplom.travel.configuration;

import org.flywaydb.core.Flyway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.flyway.FlywayProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties({FlywayProperties.class})
public class FlywayConfiguration {
    @Bean(initMethod = "migrate")
    public Flyway flyway(FlywayProperties flywayProperties) {
        return Flyway.configure()
                .dataSource(
                        flywayProperties.getUrl(),
                        flywayProperties.getUser(),
                        flywayProperties.getPassword()
                )
                .locations(flywayProperties.getLocations().toArray(String[]::new))
                .sqlMigrationPrefix(flywayProperties.getSqlMigrationPrefix())
                .baselineOnMigrate(true)
                .defaultSchema(flywayProperties.getDefaultSchema())
                .load();
    }
}