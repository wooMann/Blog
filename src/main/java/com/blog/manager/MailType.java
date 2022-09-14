package com.blog.manager;

import com.blog.manager.DTO.MailServiceMessage;

public interface MailType {
    public MailServiceMessage signUpMail(String string) ;

    public MailServiceMessage findPasswordMail(String string) ;
}
