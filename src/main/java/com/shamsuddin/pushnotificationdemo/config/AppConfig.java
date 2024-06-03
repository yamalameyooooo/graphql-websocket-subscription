package com.shamsuddin.pushnotificationdemo.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean(name = "objectMapper")
    public ObjectMapper objectMapper(){
        return new ObjectMapper();
    }
}
