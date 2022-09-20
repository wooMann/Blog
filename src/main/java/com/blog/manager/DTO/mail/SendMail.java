package com.blog.manager.DTO.mail;

import com.blog.manager.DTO.MailServiceMessage;

public interface SendMail {
     MailServiceMessage message(String userTokenId);
}
