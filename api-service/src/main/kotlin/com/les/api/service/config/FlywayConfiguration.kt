package com.les.api.service.config

import org.flywaydb.core.Flyway
import org.springframework.beans.factory.config.ConfigurableBeanFactory
import org.springframework.beans.factory.config.ConfigurableBeanFactory.SCOPE_PROTOTYPE
import org.springframework.boot.autoconfigure.flyway.FlywayProperties
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Scope

@Configuration(proxyBeanMethods = false)
@EnableConfigurationProperties(FlywayProperties::class)
class FlywayConfiguration {

    @Bean(initMethod = "migrate")
    @Scope(SCOPE_PROTOTYPE)
    fun flyway(flywayProperties: FlywayProperties): Flyway {
        return Flyway(
            Flyway.configure()
                .baselineOnMigrate(true)
                .validateMigrationNaming(flywayProperties.isValidateMigrationNaming)
                .dataSource(flywayProperties.url, flywayProperties.user, flywayProperties.password)
        )
    }
}