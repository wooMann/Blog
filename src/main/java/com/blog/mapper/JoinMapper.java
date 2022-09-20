package com.blog.mapper;

import com.blog.data.dto.user.UserDTO;
import com.blog.library.mail.SendMailDTO;

import javax.servlet.http.HttpServletRequest;

public class JoinMapper{
    public static UserDTO mapping(HttpServletRequest request) {
        UserDTO dto = new UserDTO();
        dto.setEmail(request.getParameter("email"));
        dto.setPassword(request.getParameter("password"));
        dto.setName(request.getParameter("name"));
        return dto;
    }
}
