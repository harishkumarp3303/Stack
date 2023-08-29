package com.practice.practice.Configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {
    

    @Bean
    public SMS getSMS(){
        return new SMS(789237722,"SMS sent succesfully");
    }


    @Bean
    @ConfigurationProperties(prefix = "email")
    public Email getEmail(){
        return new Email();
    }
}
