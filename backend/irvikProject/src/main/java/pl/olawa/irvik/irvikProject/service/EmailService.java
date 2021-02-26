package pl.olawa.irvik.irvikProject.service;

import javax.mail.MessagingException;

public interface EmailService {

    void sendEmail(String to, String body, String topic) throws MessagingException;


}
