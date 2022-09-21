package com.blog.mapper;

import com.blog.data.dto.user.UserDTO;
import com.blog.util.Sha256HashGenerator;

import javax.servlet.http.HttpServletRequest;

public class LoginMapper {
    public static UserDTO mapping(HttpServletRequest request) {
        return UserDTO.builder()
                .email(request.getParameter("email"))
                .password(request.getParameter("password"))
                .build();
    }
}
