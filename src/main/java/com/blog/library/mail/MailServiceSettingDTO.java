package com.blog.library.mail;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class MailServiceSettingDTO {
    String from ;
    String username;
    String password ;
    String host;
}
