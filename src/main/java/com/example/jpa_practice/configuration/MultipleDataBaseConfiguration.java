package com.example.jpa_practice.configuration;


import jakarta.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import javax.sql.DataSource;
import java.util.Map;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        basePackages = "com.example.jpa_practice.repository.mySql",
        entityManagerFactoryRef = "mysqlCLocalContainerEntityManagerFactory",
        transactionManagerRef = "mysqlPlatformTransactionManager"
)

public class MultipleDataBaseConfiguration {

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.mysql")
    public DataSource mysqlDatabase(){
        return DataSourceBuilder.create().build();
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean mysqlCLocalContainerEntityManagerFactory(
            EntityManagerFactoryBuilder builder,
            DataSource mysqlDatabase
    ) {
        return builder
                .dataSource(mysqlDatabase)
                .packages("com.example.jpa_practice.entity.mysql")
                .persistenceUnit("mysqlPersistenceUnit")
                .properties(Map.of("hibernate.dialect", "org.hibernate.dialect.MySQLDialect"))
                .build();
    }

    @Bean(name = "mysqlPlatformTransactionManager")
    public PlatformTransactionManager mysqlPlatformTransactionManager(
            @Qualifier("mysqlCLocalContainerEntityManagerFactory") EntityManagerFactory mysqlEntityManagerFactory) {
        return new JpaTransactionManager(mysqlEntityManagerFactory);
    }
//    @Bean
//    public JpaVendorAdapter jpaVendorAdapter() {
//        return new HibernateJpaVendorAdapter();
//    }

//    @Bean(name = "mysqlCLocalContainerEntityManagerFactory")
//    public LocalContainerEntityManagerFactoryBean mysqlCLocalContainerEntityManagerFactory(
//            @Qualifier("mysqlDatabase") DataSource dataSource,
//            JpaVendorAdapter jpaVendorAdapter) {   // ✅ Injected JpaVendorAdapter
//        LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
//        factoryBean.setDataSource(dataSource);
//        factoryBean.setJpaVendorAdapter(jpaVendorAdapter);
//        factoryBean.setPackagesToScan("com.example.jpa_practice.entity.mysql");
//        factoryBean.setPersistenceUnitName("mysql");
//        factoryBean.setJpaPropertyMap(Map.of("hibernate.dialect", "org.hibernate.dialect.MySQLDialect"));
//        return factoryBean;
//    }

}