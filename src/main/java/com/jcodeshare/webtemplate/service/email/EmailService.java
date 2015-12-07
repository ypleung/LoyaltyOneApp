package com.jcodeshare.webtemplate.service.email;

import javax.mail.internet.MimeMessage;

public interface EmailService {
    
    public void sendMessage(MimeMessage message);
    
}
