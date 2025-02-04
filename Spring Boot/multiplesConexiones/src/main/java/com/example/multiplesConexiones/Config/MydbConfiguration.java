package com.example.multiplesConexiones.Config;

import jakarta.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

@Configuration
@EnableJpaRepositories(
        basePackages = "com.example.multiplesConexiones.Repository.Mydb",
        entityManagerFactoryRef = "mydbEntityManagerFactory",
        transactionManagerRef = "mydbTransactionManager"
)
public class MydbConfiguration {

    @Primary
    @Bean(name = "mydbEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean mydbEntityManagerFactory(
            EntityManagerFactoryBuilder builder,
            @Qualifier("mydbDataSource") DataSource dataSource
    ) {
        return builder
                .dataSource(dataSource)
                .packages("com.example.multiplesConexiones.Entities")
                .persistenceUnit("mydb")
                .build();
    }

    @Primary
    @Bean(name = "mydbTransactionManager")
    public PlatformTransactionManager mydbTransactionManager(
            @Qualifier("mydbEntityManagerFactory") EntityManagerFactory mydbEntityManagerFactory
    ) {
        return new JpaTransactionManager(mydbEntityManagerFactory);
    }
}