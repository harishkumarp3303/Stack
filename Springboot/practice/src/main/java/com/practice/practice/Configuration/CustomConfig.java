package com.practice.practice.Configuration;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.practice.practice.entity.Person;

@Configuration
public class CustomConfig {

    private String hostName;
    private int port;
    private String from;

    


    public CustomConfig(String hostName, int port, String from) {
        this.hostName = hostName;
        this.port = port;
        this.from = from;

        System.out.println("Host name :"+hostName);
    }




    @Bean
    Person personbean(){
        return new Person();
    }
}

