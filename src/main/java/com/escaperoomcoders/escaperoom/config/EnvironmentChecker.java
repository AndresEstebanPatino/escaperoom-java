package com.escaperoomcoders.escaperoom.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class EnvironmentChecker implements CommandLineRunner {

    @Value("${SPRING_DATASOURCE_URL}")
    private String datasourceUrl;

    @Value("${EMAIL_USERNAME}")
    private String emailUsername;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Datasource URL: " + datasourceUrl);
        System.out.println("Email Username: " + emailUsername);
    }
}
