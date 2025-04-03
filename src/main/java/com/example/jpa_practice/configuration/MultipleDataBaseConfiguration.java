//package com.example.jpa_practice.configuration;
//
//
//import jakarta.persistence.EntityManagerFactory;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.boot.jdbc.DataSourceBuilder;
//import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.orm.jpa.JpaTransactionManager;
//import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
//import org.springframework.transaction.PlatformTransactionManager;
//
//import javax.sql.DataSource;
//import java.util.Map;
//
//@Configuration
//public class MultipleDataBaseConfiguration {
//
//
//
//    @Bean
//    @ConfigurationProperties(prefix = "spring.datasource.mysql")
//    public DataSource mysqlDatabase(){
//        return DataSourceBuilder.create().build();
//    }
//
//    @Bean
//    public LocalContainerEntityManagerFactoryBean mysqlCLocalContainerEntityManagerFactory(
//            EntityManagerFactoryBuilder entityManagerFactoryBuilder,
//            DataSource mysqlDatabase
//    ){
//        return entityManagerFactoryBuilder
//                .dataSource(mysqlDatabase)
//                .packages("com.example.jpa_practice.entities.mysql")
//                .persistenceUnit("mysqlPersistenceUnit")
//                .properties(Map.of("hibernate.dialect","org.hibernate.dialect.MySQLDialect"))
//                .build();
//    }
//
//    @Bean
//    public PlatformTransactionManager mysqlPlatformTransactionManager(EntityManagerFactory mysqlCLocalContainerEntityManagerFactory){
//        return new JpaTransactionManager(mysqlCLocalContainerEntityManagerFactory);
//    }
//
//
//
//
//}
