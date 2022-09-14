package com.blog.manager.DTO;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class MailServiceSetting {
    String from ;
    String username;
    String password ;
    String host;
}
