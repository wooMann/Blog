package com.blog.manager.DTO;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class MailServiceMessage {
    private String title;
    private String body;
}
