package com.blog.controller;


import com.blog.dto.EmailTokensDTO;
import com.blog.dto.user.UserDTO;
import com.blog.entity.EmailTokens;
import com.blog.entity.User;
import com.blog.service.EmailTokenService;
import com.blog.service.MailService;
import com.blog.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import java.io.IOException;
import java.util.Optional;
import java.util.UUID;



public class JoinProcController implements Controller {
    @Override
    public String httpMethod() {
        return "POST";
    }

    private UserDTO makeDTO(HttpServletRequest request){
        UserDTO dto = new UserDTO();
        dto.setEmail(request.getParameter("email"));
        dto.setPassword(request.getParameter("password"));
        dto.setName(request.getParameter("name"));
        return dto;
    }

    private EmailTokensDTO makeEmailTokensDTO(int userId , String token){
        EmailTokensDTO dto = new EmailTokensDTO();
        dto.setUserId(userId);
        dto.setToken(token);
        dto.setState(0);

        return dto;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserService userService = new UserService();
        MailService mailService = new MailService();
        EmailTokenService emailTokenService = new EmailTokenService();
        UUID uuid = UUID.randomUUID();
        String code[] = String.valueOf(uuid).split("-");

        User findResult = userService.findUserByEmail();
        if (findResult == null){
            Optional<User> joinResult = userService.join(makeDTO(request));
            if(joinResult == null){
                request.setAttribute("path","/login.do");
                request.setAttribute("message","회원가입 실패.");
                return "/posts/pathHandler.jsp";
            }
            request.setAttribute("path","/login.do");
            request.setAttribute("message","회원가입 확인 이메일이 전송되었습니다.");
            emailTokenService.createEmailToken(makeEmailTokensDTO(joinResult.get().getId(), code[0]));
            mailService.sendMail(joinResult.get(),code[0]);

        }else {
            request.setAttribute("path","javascript:history.back()");
            request.setAttribute("message","이미 존재하는 메일명.");
        }
        return "/posts/pathHandler.jsp";
    }
}
