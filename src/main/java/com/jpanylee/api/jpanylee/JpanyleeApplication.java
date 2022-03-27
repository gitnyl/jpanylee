package com.jpanylee.api.jpanylee;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.quartz.QuartzAutoConfiguration;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import javax.servlet.annotation.WebListener;

@SpringBootApplication(exclude = {QuartzAutoConfiguration.class})
@EnableJpaAuditing
@WebListener
public class JpanyleeApplication extends SpringBootServletInitializer {

    private static ConfigurableApplicationContext context;


    public static void main(String[] args) {
        SpringApplication.run(JpanyleeApplication.class, args);
    }

    public static void restart() {
        ApplicationArguments args = context.getBean(ApplicationArguments.class);

        Thread thread = new Thread(() -> {
            context.close();
            context = SpringApplication.run(JpanyleeApplication.class, args.getSourceArgs());
        });

        thread.setDaemon(false);
        thread.start();
    }


}
