package com.ranjay.spring.nhssytems.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

@Configuration
@EnableJpaRepositories(basePackages = "com.ranjay.spring.nhssytems.repository")
@PropertySource("classpath:application.properties")
public class DataConfig{

    @Autowired
    private Environment env;

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(){
        LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();

        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        factoryBean.setDataSource(dataSource());
        factoryBean.setJpaVendorAdapter(vendorAdapter);
        factoryBean.setPackagesToScan(env.getProperty("nhs.entity.package"));
        factoryBean.setJpaProperties(getHibernateProperties());
        return factoryBean;
    }

    @Bean
    public DataSource dataSource(){
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setUsername(env.getProperty("nhs.datasource.username"));
        dataSource.setPassword(env.getProperty("nhs.datsource.password"));
        dataSource.setUrl(env.getProperty("nhs.datasource.url"));
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        return dataSource;
    }

    private Properties getHibernateProperties(){
        Properties properties = new Properties();
        properties.put("hibernate.dialect", env.getProperty("hibernate.dialect"));
        properties.put("hibernate.implicit_naming_strategy",env.getProperty("hibernate.implicit_naming_strategy"));
        properties.put("hibernate.format_sql", env.getProperty("hibernate.format_sql"));
        properties.put("hibernate.show_sql", env.getProperty("hibernate.show_sql"));
        properties.put("hibernate.hbm2ddl.auto", env.getProperty("hibernate.hbm2ddl.auto"));
        return properties;
    }
}