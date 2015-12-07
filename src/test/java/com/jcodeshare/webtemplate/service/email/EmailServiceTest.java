package com.jcodeshare.webtemplate.service.email;

import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.*;

import java.lang.InterruptedException;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.Properties;

import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;

import org.junit.Test;
import org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.TestPropertySource;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jcodeshare.webtemplate.service.email.EmailService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:emailservice-test.xml" })
public class EmailServiceTest {

    @Autowired
    private EmailService emailService;

    private Session SESSION = Session
            .getDefaultInstance(System.getProperties());

    @Autowired
    private Properties configProp;
    
    private String to;
    private String from;
    private String host;
    private String hostKey;
    private String emailDumpFile;

    final static Logger logger = LoggerFactory
            .getLogger(EmailServiceTest.class);

    @Test
    public void testSendMessage() {
        MimeMessage email = new MimeMessage(SESSION);
        to = configProp.getProperty("email.to");
        host = configProp.getProperty("host");
        from = configProp.getProperty("email.from");
        hostKey = configProp.getProperty("email.hostKey");
        emailDumpFile = configProp.getProperty("email.emailDumpFile");

        logger.info("EmailServiceTest values TO: " + to + " FROM: " + from
                + " EMAIL_DUMP_FILE: " + emailDumpFile + " host: " + host);

        assertNotNull("Spring bean emailService failed to be created!",
                emailService);
        String emailContent = "Email Service content: " + new Date();

        try {
            assertNotNull("Properties lookup failed! From email: " + from, from);
            assertTrue("TO EMAIL is not yuenpingleung@gmail.com it is: " + to,
                    to.equals("yuenpingleung@gmail.com"));

            email.setFrom(new InternetAddress(from));
            email.addRecipient(Message.RecipientType.TO,
                    new InternetAddress(to));
            email.setSubject("EmailService Test");
            email.setText(emailContent);

        } catch (MessagingException me) {
            logger.info("Test Error: Exception thrown on trying to create a test email, "
                    + me.getMessage());
        }

        emailService.sendMessage(email);

        File emailFile = new File(emailDumpFile);

        Scanner contents = null;
        boolean result = false;
        try {
            Thread.sleep(5000);
            contents = new Scanner(emailFile);
            while (contents.hasNextLine() && !result) {
                result = contents.nextLine().indexOf(emailContent) >= 0;
            }

            assertTrue("Email message(\'" + emailContent
                    + "\') found in email dump file: " + emailDumpFile + " "
                    + result, result);
        } catch (IOException e) {
            logger.info("Test Error: Difficulty opening email dump file, "
                    + emailFile.getName() + " " + e.getMessage());
        } catch (InterruptedException ine) {
            logger.info("Test Error: Difficulty opening email dump file, "
                    + emailFile.getName() + " " + ine.getMessage());
        } finally {
            if (contents != null) {
                contents.close();
            }
        }
        logger.info("EmailServiceTest.sendMessage successfully executed!");
    }

}
