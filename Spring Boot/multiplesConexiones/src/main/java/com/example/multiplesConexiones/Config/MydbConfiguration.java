package com.example.multiplesConexiones.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.core.env.Environment;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        basePackages = "com.example.multiplesConexiones.Repository.Mydb",
        entityManagerFactoryRef = "mydbEntityManagerFactory",
        transactionManagerRef = "mydbTransactionManager"
)
public class MydbConfiguration {
    @Autowired
    private Environment env;

    @Bean(name = "mydbDataSource")
    public DataSource mydbDataSource() {
        return DataSourceBuilder.create()
                .driverClassName(env.getProperty("mydb.datasource.driver-class-name"))
                .url(env.getProperty("mydb.datasource.url"))
                .username(env.getProperty("mydb.datasource.username"))
                .password(env.getProperty("mydb.datasource.password"))
                .build();
    }

    @Bean(name = "mydbEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean mydbEntityManagerFactory(){
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(mydbDataSource());
        em.setPackagesToScan("com.example.multiplesConexiones.Entities.Mydb");

        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);

        Map<String, Object> properties = new HashMap<>();
        properties.put("hibernate.hbm2ddl.auto", env.getProperty("hibernate.hbm2ddl.auto"));
        properties.put("hibernate.dialect", env.getProperty("hibernate.dialect"));
        em.setJpaPropertyMap(properties);

        return em;
    }

    @Bean(name = "mydbTransactionManager")
    public PlatformTransactionManager mydbTransactionManager() {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(mydbEntityManagerFactory().getObject());
        return transactionManager;
    }


}