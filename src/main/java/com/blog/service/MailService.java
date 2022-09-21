package com.blog.service;

import com.blog.library.mail.SendMailDTO;
import com.blog.library.mail.SendMail;
import com.blog.library.mail.SendMailManager;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class MailService {

    public void sendMail(SendMailDTO dto, SendMail sendMail) {

        SendMailManager sendMailManager = new SendMailManager();

        Properties props = new Properties();
        props.put("mail.smtp.ssl.protocols", "TLSv1.2");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", sendMailManager.mailTrap().getHost());
        props.put("mail.smtp.port", "2525");

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(sendMailManager.mailTrap().getUsername(), sendMailManager.mailTrap().getPassword());
                    }
                });
        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(sendMailManager.mailTrap().getFrom()));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(dto.getEmail()));
            message.setSubject(sendMail.message(dto.getToken()).getTitle());
            message.setContent(sendMail.message(dto.getToken()).getBody(),"text/html; charset=UTF-8");
            Transport.send(message);
            System.out.println("메일발송완료");
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}
