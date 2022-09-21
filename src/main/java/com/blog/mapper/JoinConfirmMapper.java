package com.blog.mapper;

import com.blog.data.dto.EmailTokensDTO;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

public class JoinConfirmMapper {

    public static EmailTokensDTO mapping(HttpServletRequest request){
        EmailTokensDTO dto = new EmailTokensDTO();
        dto.setToken(request.getParameter("token"));
        dto.setAuthAt(new Date());
        dto.setState(1);

        return dto;
    }
}
