//package com.example.jpa_practice.configuration;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.orm.jpa.JpaVendorAdapter;
//import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
//import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
//import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
//
//import java.util.HashMap;
//
//@Configuration
//public class JpaBuilderConfig {
//
//    @Bean
//    public JpaVendorAdapter jpaVendorAdapter() {
//        return new HibernateJpaVendorAdapter();
//    }
//
//    @Bean
//    public EntityManagerFactoryBuilder entityManagerFactoryBuilder(JpaVendorAdapter jpaVendorAdapter) {
//        return new EntityManagerFactoryBuilder(jpaVendorAdapter, new HashMap<>(), null);
//    }
//}
