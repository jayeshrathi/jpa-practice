//package com.example.jpa_practice.configuration;
//
//
//import jakarta.persistence.EntityManagerFactory;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.boot.jdbc.DataSourceBuilder;
//import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//import org.springframework.orm.jpa.JpaTransactionManager;
//import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
//import org.springframework.transaction.PlatformTransactionManager;
//import org.springframework.transaction.annotation.EnableTransactionManagement;
//
//import javax.sql.DataSource;
//import java.util.Map;
//
//@EnableTransactionManagement
//@Configuration
//@EnableJpaRepositories(
//        basePackages = "com.example.jpa_practice.repository.postgresSql",
//        entityManagerFactoryRef = "postgresSqlLocalContainerEntityManagerFactoryBean",
//        transactionManagerRef = "postgresSqlTransactionManager"
//)
//public class PostgresSqlConfiguration {
//    @Bean
//    @ConfigurationProperties(prefix = "spring.datasource.postgresql")
//    public DataSource postgresSqlDatabase(){
//        return DataSourceBuilder.create().build();
//    }
//
//    @Bean
//    public LocalContainerEntityManagerFactoryBean postgresSqlLocalContainerEntityManagerFactoryBean(
//            EntityManagerFactoryBuilder builder,
//            DataSource postgresSqlDatabase
//    ){
//        return builder
//                .dataSource(postgresSqlDatabase)
//                .packages("com.example.jpa_practice.entity.postgresSql")
//                .properties(Map.of("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect"))
//                .persistenceUnit("postgresPersistenceUnit")
//                .build();
//    }
//
//    @Bean
//    public PlatformTransactionManager postgresSqlTransactionManager(EntityManagerFactory postgresSqlLocalContainerEntityManagerFactoryBean){
//        return new JpaTransactionManager(postgresSqlLocalContainerEntityManagerFactoryBean);
//
//    }
//
//
//}
