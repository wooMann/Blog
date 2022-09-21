package com.blog.mapper;

import com.blog.data.dto.user.UserDTO;

import javax.servlet.http.HttpServletRequest;

public class UserMapper {
    public static UserDTO mapping(HttpServletRequest request){
        UserDTO dto = new UserDTO();
        dto.setId(Integer.valueOf(request.getParameter("id")));
        dto.setEmail(request.getParameter("email"));
        dto.setPassword(request.getParameter("password"));
        dto.setName(request.getParameter("name"));
        return dto;
    }
}
