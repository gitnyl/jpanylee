package com.jpanylee.common;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@Setter
@Getter
@ConfigurationProperties("spring.datasource.hikari")
public class DataSourceHikari {
    private String driverClassName;
    private String url;
    private String username;
    private String password;
    private Integer maximumPoolSize;
    private Integer maxLifetime;
    private boolean autoCommit;
}