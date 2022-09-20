package com.blog.data.dto.user;

import com.blog.data.entity.User;
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

    public User makeUser(){
        return User.builder()
                .id(getId())
                .email(getEmail())
                .password(getPassword())
                .name(getName())
                .build();
    }
}
