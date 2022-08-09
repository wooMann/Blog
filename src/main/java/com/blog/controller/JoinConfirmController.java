package com.blog.controller;

import com.blog.dto.EmailTokensDTO;
import com.blog.service.EmailTokenService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

public class JoinConfirmController implements Controller{
    @Override
    public String httpMethod() {
        return "GET";
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EmailTokenService emailTokenService = new EmailTokenService();
        emailTokenService.

        return "/posts/joinConfirm.jsp";
    }

    private EmailTokensDTO makeDTO(HttpServletRequest request){
        EmailTokensDTO dto = new EmailTokensDTO();
        dto.setToken(request.getParameter("token"));
        dto.setAuthAt(new Date());

        return dto;
    }
}
