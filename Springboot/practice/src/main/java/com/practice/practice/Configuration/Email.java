package com.practice.practice.Configuration;

public class Email {
    
    private String emailId;

    private String subject;

    private String message;

    

    public Email() {
    }

    

    public Email(String emailId, String subject, String message) {
        this.emailId = emailId;
        this.subject = subject;
        this.message = message;
    }



    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void sendEmail() {

        System.out.println("Sending Email");
        System.out.println("Email Id: " + emailId);
        System.out.println("Subject: " + subject);
        System.out.println("Message: " + message);
        System.out.println("Email Sent Successfully");

        // Thread t1=new Thread(()->{
        //     for(int i=0;i<10;i++){
        //         try {
        //             Thread.sleep(1000);
        //         } catch (InterruptedException e) {
        //             // TODO Auto-generated catch block
        //             e.printStackTrace();
        //         }
        //         System.out.println("Thread 1: "+i);
        //     }
        //     }
        // );

        // t1.start();

    }

    
}
