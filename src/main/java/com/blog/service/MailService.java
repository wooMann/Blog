package com.blog.service;

import com.blog.entity.User;
import com.blog.manager.SendMailManager;
import com.blog.manager.SessionManager;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class MailService {

    /*private static final String from = "from@example.com";
    final String username = "2ee152d4bfe31d";
    final String password = "285a9a3392b65f";
    String host = "smtp.mailtrap.io";*/


    public void sendMail(User user,String code) {
        String to = user.getEmail();

        SendMailManager sendMailManager = new SendMailManager();
        SendMailManager.MailServiceInfo  mailServiceInfo = sendMailManager.mailTrap();
        SendMailManager.MailServiceType mailServiceType = sendMailManager.signUpMail(code);

        Properties props = new Properties();
        props.put("mail.smtp.ssl.protocols", "TLSv1.2");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", mailServiceInfo.getHost());
        props.put("mail.smtp.port", "2525");

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(mailServiceInfo.getUsername(), mailServiceInfo.getPassword());
                    }
                });
        try {
            //String content = "회원가입 확인을 해주세요 - " + "<a href = 'http://localhost:8081/joinConfirm.do?token="+code+"'> 확인 </a>";
            String content = mailServiceType.getBody();
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(mailServiceInfo.getFrom()));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
            //message.setSubject("회원가입 확인메일입니다");
            message.setSubject(mailServiceType.getTitle());
            message.setContent(content,"text/html; charset=UTF-8");
            Transport.send(message);
            System.out.println("메일발송완료");
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}
