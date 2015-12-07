package com.jcodeshare.webtemplate.service.email;

import com.jcodeshare.webtemplate.service.email.EmailService;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
 
/**
 * @author YP Leung
 */
public class EmailServiceImpl implements EmailService {
    
    public void sendMessage(MimeMessage message) {
        try{
            Transport.send(message);
            System.out.println("Sent message successfully....");
         }catch (MessagingException me) {
            me.printStackTrace();
         }
    }
}

