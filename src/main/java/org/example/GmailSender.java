package org.example;

import io.github.cdimascio.dotenv.Dotenv;
import javax.mail.*;
import javax.mail.internet.*;
import java.util.Properties;

public class GmailSender {

    public static void main(String[] args) {
        try {
            // Load the confingurations in .env
            Dotenv dotenv = Dotenv.configure()
                    .ignoreIfMalformed()
                    .ignoreIfMissing()
                    .load();
            String username = dotenv.get("GMAIL_USERNAME");
            String password = dotenv.get("GMAIL_PASSWORD");

            //Verify if the username and password from .env is not null
            if(username == null || password == null){
                throw new RuntimeException("Username and/or password are missing");
            }

            //Configure email subject and body
            String to = dotenv.get("GMAIL_TO");
            String subject = "Testing e-mail functionality";
            String body = "This e-mail was send successfully";

            //Calls the method to send the email
            sendGmail(username, password, to, subject, body);

            System.out.println("E-mail sent successfully");
        } catch (Exception e) {
            System.err.println("Error to send the e-mail");
            e.printStackTrace();
        }
    }

    public static void sendGmail(String username, String password,
                                 String to, String subject, String body)
            throws MessagingException {

        // Verify the parameters
        if(username == null || username.isBlank()) {
            throw new IllegalArgumentException("Username can not be null or empty");
        }
        if(to == null || to.isBlank()) {
            throw new IllegalArgumentException("Receiver can not be null or empty");
        }

        // Fixed configurations SMTP for GMAIL
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.ssl.protocols", "TLSv1.2");
        props.put("mail.smtp.ssl.trust", "smtp.gmail.com");
        props.put("mail.smtp.auth.mechanisms", "PLAIN LOGIN");
        props.put("mail.smtp.connectiontimeout", "10000");
        props.put("mail.smtp.timeout", "10000");
        props.put("mail.smtp.writetimeout", "10000");

        //Creates login session
        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });
        session.setDebug(true);

        //Prepare the message to send
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
            message.setSubject(subject);
            message.setText(body);

            Transport.send(message);
        } catch (MessagingException e) {
            throw new MessagingException("Authentication error please verify:\n" +
                    "1. Your username and password\n" +
                    "2. If your 2FA and APP password is enable\n", e);
        }
    }
}