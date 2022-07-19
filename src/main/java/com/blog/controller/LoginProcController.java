package com.blog.controller;


import com.blog.dto.user.UserDTO;
import com.blog.entity.User;
import com.blog.service.UserService;
import com.blog.util.Sha256HashGenerator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


public class LoginProcController implements Controller {


    @Override
    public String httpMethod() {
        return "POST";
    }

    private UserDTO makeDTO(HttpServletRequest request){
        UserDTO dto = new UserDTO();
        dto.setEmail(request.getParameter("email"));
        dto.setPassword(Sha256HashGenerator.hashGenerate(request.getParameter("password")));
        return dto;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserService userService = new UserService(request);
        HttpSession session = request.getSession();
        UserDTO userDTO = makeDTO(request);
        User result = new User();


        if (!userService.findByEmail(userDTO)) {
            request.setAttribute("path", "javascript:history.back()");
            request.setAttribute("message","존재하지 않는 회원입니다.");
            return "/posts/pathHandler.jsp";
        }

        result = userService.login(userDTO);

        if (result == null){
            request.setAttribute("path", "javascript:history.back()");
            request.setAttribute("message","비밀번호를 확인해 주세요");
            return "/posts/pathHandler.jsp";
        }

        request.setAttribute("path", "/main.do");
        session.setAttribute("SESSION_USER_ID",result.getId());
        session.setAttribute("SESSION_USER_EMAIL",result.getEmail());
        session.setAttribute("SESSION_USER_NAME",result.getName());
        return "/posts/pathHandler.jsp";
    }
}
