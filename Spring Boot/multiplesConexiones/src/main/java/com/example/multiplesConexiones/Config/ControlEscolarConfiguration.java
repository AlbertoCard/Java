package com.example.multiplesConexiones.Config;

import jakarta.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

@Configuration
@EnableJpaRepositories(
        basePackages = "com.example.multiplesConexiones.Repository.ControlEscolar",
        entityManagerFactoryRef = "controlEscolarEntityManagerFactory",
        transactionManagerRef = "controlEscolarTransactionManager"
)
public class ControlEscolarConfiguration {

    @Bean(name = "controlEscolarEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean controlEscolarEntityManagerFactory(
            EntityManagerFactoryBuilder builder,
            @Qualifier("ControlEscolarDataSource") DataSource dataSource
    ) {
        return builder
                .dataSource(dataSource)
                .packages("com.example.multiplesConexiones.Entities")
                .persistenceUnit("controlEscolar")
                .build();
    }

    @Bean(name = "controlEscolarTransactionManager")
    public PlatformTransactionManager controlEscolarTransactionManager(
            @Qualifier("controlEscolarEntityManagerFactory") EntityManagerFactory controlEscolarEntityManagerFactory
    ) {
        return new JpaTransactionManager(controlEscolarEntityManagerFactory);
    }
}