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

    private UserDTO makeDTO(HttpServletRequest request) {
        UserDTO dto = new UserDTO();
        dto.setEmail(request.getParameter("email"));
        dto.setPassword(Sha256HashGenerator.hashGenerate(request.getParameter("password")));
        return dto;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserService userService = new UserService();
        HttpSession session = request.getSession();
        UserDTO userDTO = makeDTO(request);
        User result = new User();

        try {
            boolean findResult = userService.findByEmail(userDTO);
            User loginResult = userService.login(userDTO);

            if (!findResult) {
                request.setAttribute("path", "javascript:history.back()");
                request.setAttribute("message", "존재하지 않는 회원입니다.");
            } else if (loginResult == null) {
                request.setAttribute("path", "javascript:history.back()");
                request.setAttribute("message", "비밀번호를 확인해 주세요");
            } else {
                boolean tokenResult = userService.checkEmailToken(loginResult.getId());
                if (!tokenResult) {
                    request.setAttribute("path", "javascript:history.back()");
                    request.setAttribute("message", "회원가입 이메일 확인을 해주세요");
                }else {
                    request.setAttribute("path", "/main.do");
                    session.setAttribute("SESSION_USER_ID", loginResult.getId());
                    session.setAttribute("SESSION_USER_EMAIL", loginResult.getEmail());
                    session.setAttribute("SESSION_USER_NAME", loginResult.getName());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "/posts/pathHandler.jsp";
    }
}
