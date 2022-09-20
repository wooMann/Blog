package com.blog.data.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
public class EmailTokensDTO implements DTO{
    private Integer id;
    private Integer userId;
    private String token;
    private Date authAt;
    private Integer state;
    private Date sendedAt;
}
