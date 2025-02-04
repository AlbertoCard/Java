package com.example.multiplesConexiones.Config;

import jakarta.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Configuration
@EnableJpaRepositories(
        basePackages = "com.example.multiplesConexiones.Repository.ControlEscolar",
        entityManagerFactoryRef = "controlEscolarEntityManagerFactory",
        transactionManagerRef = "controlEscolarTransactionManager"
)
public class ControlEscolarConfiguration {
    @Autowired
    private Environment env;

    @Bean(name = "controlEscolarDataSource")
    public DataSource controlEscolarDataSource() {
        return DataSourceBuilder.create()
                .driverClassName(env.getProperty("controlescolar.datasource.driver-class-name"))
                .url(env.getProperty("controlescolar.datasource.url"))
                .username(env.getProperty("controlescolar.datasource.username"))
                .password(env.getProperty("controlescolar.datasource.password"))
                .build();
    }

    @Bean(name = "controlEscolarEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean controlEscolarEntityManagerFactory() {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(controlEscolarDataSource());
        em.setPackagesToScan("com.example.multiplesConexiones.Entities.ControlEscolar");

        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);

        Map<String, Object> properties = new HashMap<>();
        properties.put("hibernate.hbm2ddl.auto", env.getProperty("hibernate.hbm2ddl.auto"));
        properties.put("hibernate.dialect", env.getProperty("hibernate.dialect"));
        em.setJpaPropertyMap(properties);

        return em;
    }

    @Bean(name = "controlEscolarTransactionManager")
    public PlatformTransactionManager controlEscolarTransactionManager() {
            JpaTransactionManager transactionManager = new JpaTransactionManager();
            transactionManager.setEntityManagerFactory(controlEscolarEntityManagerFactory().getObject());
            return transactionManager;
    }
}
