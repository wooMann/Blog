package com.blog.library.mail;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class MailServiceMessageDTO {
    private String title;
    private String body;
}
