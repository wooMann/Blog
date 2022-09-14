package com.blog.service;

import com.blog.entity.User;
import com.blog.manager.DTO.SendMailDTO;
import com.blog.manager.SendMailManager;
import com.blog.manager.SessionManager;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class MailService {

    public void sendMail(SendMailDTO dto) {

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
            String content = dto.getMailType().equals("signUp") ? sendMailManager.signUpMail(dto.getToken()).getBody() : sendMailManager.findPasswordMail(dto.getToken()).getBody();
            String title = dto.getMailType().equals("signUp") ? sendMailManager.signUpMail(dto.getToken()).getTitle() : sendMailManager.findPasswordMail(dto.getToken()).getTitle();

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(sendMailManager.mailTrap().getFrom()));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(dto.getEmail()));
            message.setSubject(title);
            message.setContent(content,"text/html; charset=UTF-8");
            Transport.send(message);
            System.out.println("메일발송완료");
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}
