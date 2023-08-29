package com.practice.practice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practice.practice.Configuration.Charger;
import com.practice.practice.Configuration.Email;
import com.practice.practice.Configuration.SMS;
import com.practice.practice.repository.UserRepo;

@RestController
public class UserController {

    @Value("${msg}")
    private String msg;
    
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private Email email;

    @Autowired
    private SMS sms;

    @Autowired
    private Charger charger;

    @GetMapping("/user")
    public String getUser(){

        return msg;
    }

    @GetMapping("SMS")
    public String getSMS(){

        sms.sendSms();
        return sms.getMessage();
    
    }


    @GetMapping("Email")
    public String getEmail(){

        email.sendEmail();
        return email.getMessage();
    }


    @GetMapping("charger")
    public String getCharger(){
    
        charger.charge();
        return charger.getCompany();
    }
}
