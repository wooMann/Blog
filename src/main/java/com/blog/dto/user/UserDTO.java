package com.blog.dto.user;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserDTO {
    private Integer id;
    private String email;
    private String password;
    private String name;
}
