package com.blog.manager.DTO;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Builder
@ToString
public class SendMailDTO {
    private String email;
    private String token;
    private String mailType;
}
