package com.blog.controller;


import com.blog.data.dto.EmailTokensDTO;
import com.blog.data.dto.user.UserDTO;
import com.blog.data.entity.User;
import com.blog.library.mail.SendMailDTO;
import com.blog.library.mail.SignUpMail;
import com.blog.mapper.JoinMapper;
import com.blog.service.EmailTokenService;
import com.blog.service.MailService;
import com.blog.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;
import java.util.UUID;



public class JoinController implements Controller {

    @Override
    public String doGet(HttpServletRequest request, HttpServletResponse response) {
        return "/blog/join.jsp";
    }

    @Override
    public String doPost(HttpServletRequest request, HttpServletResponse response) {
        UserService userService = new UserService();
        MailService mailService = new MailService();

        EmailTokenService emailTokenService = new EmailTokenService();
        UserDTO dto = JoinMapper.mapping(request);
        UUID uuid = UUID.randomUUID();
        String code[] = String.valueOf(uuid).split("-");

        User findResult = userService.findUserByEmail(dto);
        if (findResult == null){
            Optional<User> joinResult = userService.join(dto);
            if(joinResult == null){
                request.setAttribute("path","/login.do");
                request.setAttribute("message","회원가입 실패.");
                return "/blog/pathHandler.jsp";
            }
            request.setAttribute("path","/login.do");
            request.setAttribute("message","회원가입 확인 이메일이 전송되었습니다.");
            emailTokenService.createEmailToken(makeEmailTokensDTO(joinResult.get().getId(), code[0]));
            mailService.sendMail(makeSendMailDTO(joinResult.get().getEmail(),code[0]), new SignUpMail());

        }else {
            request.setAttribute("path","javascript:history.back()");
            request.setAttribute("message","이미 존재하는 메일명.");
        }
        return "/blog/pathHandler.jsp";
    }

    private EmailTokensDTO makeEmailTokensDTO(int userId , String token){
        EmailTokensDTO dto = new EmailTokensDTO();
        dto.setUserId(userId);
        dto.setToken(token);
        dto.setState(0);

        return dto;
    }

    private SendMailDTO makeSendMailDTO(String email , String token){
        return SendMailDTO.builder()
                .email(email)
                .token(token)
                .build();
    }
}
