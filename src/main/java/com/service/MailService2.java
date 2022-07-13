package com.service;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class MailService2 {
    static final String FROM = "test@test.co.kr";
    static final String FROMNAME = "비즈플러스";
    static String TO = "woo@naver.com";
    static final String SMTP_USERNAME = "2ee152d4bfe31d";
    static final String SMTP_PASSWORD = "285a9a3392b65f";
    static final String HOST = "smtp.mailtrap.io";
    static final int PORT = 2525;

    static final String SUBJECT = "회원가입 테스트메일 입니다";
    static final String BODYCONTENTS = "회원가입 축하";

    static final String BODY = String.join(
            System.getProperty("line.separator"),
            BODYCONTENTS

    );
    public static void main(String[] args) throws Exception {
        Properties props = System.getProperties();
        props.put("mail.smtp.ssl.protocols", "TLSv1.2");
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.port", PORT);
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.auth", "true");
        Session session = Session.getDefaultInstance(props);
        MimeMessage msg = new MimeMessage(session);
        msg.setFrom(new InternetAddress(FROM, FROMNAME));
        msg.setRecipient(Message.RecipientType.TO, new InternetAddress(TO));
        msg.setSubject(SUBJECT);
        msg.setContent(BODY, "text/html;charset=euc-kr");

        Transport transport = session.getTransport();
        try {
            transport.connect(HOST, SMTP_USERNAME, SMTP_PASSWORD);
            transport.sendMessage(msg, msg.getAllRecipients());
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            transport.close();
        }
    }
}
