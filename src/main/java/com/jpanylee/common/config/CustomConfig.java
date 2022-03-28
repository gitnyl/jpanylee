package com.jpanylee.common.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.StandardEnvironment;
import org.springframework.stereotype.Component;

import java.nio.file.Path;

@Component
public class CustomConfig {
    private static final Logger logger = LoggerFactory.getLogger(CustomConfig.class);

    @Autowired
    private StandardEnvironment environment;
    private Path configPath;



    public String getValue( String key ) {
        return environment.getProperty(key);
    }

    public String getValue( String key , String defaultValue ) {
        return environment.getProperty(key, defaultValue);
    }

}
