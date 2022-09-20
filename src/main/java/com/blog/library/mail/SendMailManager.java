package com.blog.library.mail;


public class SendMailManager implements SendEmailManager {
    @Override
    public MailServiceSettingDTO mailTrap() {
        return MailServiceSettingDTO.builder()
                .from("from@example.com")
                .username("2ee152d4bfe31d")
                .password("285a9a3392b65f")
                .host("smtp.mailtrap.io")
                .build();
    }




}
