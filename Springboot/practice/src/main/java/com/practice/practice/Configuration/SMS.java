package com.practice.practice.Configuration;

public class SMS {
    
    private long number;
    private String message;

    

    public SMS() {
    }

    
    public SMS(long number, String message) {
        this.number = number;
        this.message = message;
    }


    public long getNumber() {
        return number;
    }
    public void setNumber(long number) {
        this.number = number;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }


    public void sendSms() {
        System.out.println("Sending SMS");
        System.out.println("Number: " + number);
        System.out.println("Message: " + message);
        System.out.println("SMS Sent Successfully");
    }

    
}
