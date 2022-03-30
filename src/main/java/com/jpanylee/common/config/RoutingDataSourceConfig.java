package com.jpanylee.common.config;

import com.jpanylee.common.DataSourceHikari;
import com.zaxxer.hikari.HikariDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.hibernate.jpa.boot.spi.EntityManagerFactoryBuilder;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.LazyConnectionDataSourceProxy;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@EnableJpaRepositories(
        basePackages = {"com.jpanylee.api.jpanylee"}
//        ,entityManagerFactoryRef="entityManagerFactoryA"
//        ,transactionManagerRef = "transactionManagerA"
)
@EnableTransactionManagement
@EnableAutoConfiguration
public class RoutingDataSourceConfig {

    @Primary
    @Bean(name = "routingDataSource")
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource getDataSource() {
        return DataSourceBuilder.create().build();
    }
//
//    @Primary
//    @Bean
//    public DataSource dataSource(@Qualifier("routingDataSource") DataSource routingDataSource) {
//        return DataSourceBuilder
//    }
//
//    @Bean
//    public DataSource routingDataSource(@Qualifier("hikariDataSource") DataSource dataSourceHikari) {
//
//    }

    @Primary
    @Bean(name = "sqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory(@Qualifier("routingDataSource") DataSource routingDataSource, ApplicationContext applicationContext) throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(routingDataSource);
                sqlSessionFactoryBean.setMapperLocations(applicationContext.getResources("classpath:/resources/mapper/*.xml"));
        return sqlSessionFactoryBean.getObject();
    }
    @Primary
    @Bean(name="sqlSessionTemplate")
    public SqlSessionTemplate apiSqlSessionTemplate(SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

    @Bean(name = "hikariDataSource")
    public DataSource hikariDataSource(DataSourceHikari dataSourceHikari) {
        HikariDataSource hikariDataSource = new HikariDataSource();

        hikariDataSource.setJdbcUrl(dataSourceHikari.getUrl());
        hikariDataSource.setUsername(dataSourceHikari.getUsername());
        hikariDataSource.setPassword(dataSourceHikari.getPassword());
        hikariDataSource.setMaximumPoolSize(dataSourceHikari.getMaximumPoolSize());
        hikariDataSource.setMaxLifetime(dataSourceHikari.getMaxLifetime());
        hikariDataSource.setAutoCommit(dataSourceHikari.isAutoCommit());

        return hikariDataSource;
    }

//    @Bean(name = "dataSource")
//    @Qualifier("dataSource1")
//    @ConfigurationProperties(prefix = "spring.datasource.datasource1")
//    public DataSource dataSource1() {
//        return DataSourceBuilder.create().build();
//    }
//    @Bean
//    @ConfigurationProperties(prefix = "spring.datasource")
//    public DataSource getDataSource() {
//        return DataSourceBuilder.create().build();
//    }
//    @Bean(name = "readDataSource")
//    public DataSource readDataSource(DataSource dataSource) {
//        com.zaxxer.hikari.HikariDataSource hikariDataSource = new com.zaxxer.hikari.HikariDataSource();
//        return hikariDataSource;
//    }
//    @Bean
//    public PlatformTransactionManager baseTransactionManager() {
//        JpaTransactionManager transactionManager = new JpaTransactionManager();
//        return transactionManager;
//    }


}


/*
package com.jpanylee.common.config;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.LazyConnectionDataSourceProxy;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class})
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = {"com.jpanylee.api.jpanylee"})
public class DataSourceConfig {

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource getDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean
    public DataSource dataSource(@Qualifier("dataSource") DataSource routingDataSource) {
        return new LazyConnectionDataSourceProxy(routingDataSource);
    }

    @Bean(name = "readDataSource")
    public DataSource readDataSource(DataSource dataSource) {
        HikariDataSource hikariDataSource = new HikariDataSource();
        return hikariDataSource;
    }
    @Bean
    public PlatformTransactionManager baseTransactionManager() {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        return transactionManager;
    }



}

 */