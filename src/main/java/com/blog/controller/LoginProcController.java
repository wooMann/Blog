package com.blog.controller;


import com.blog.dto.user.UserDTO;
import com.blog.entity.User;
import com.blog.manager.ResponseManager;
import com.blog.manager.SessionManager;
import com.blog.service.UserService;
import com.blog.util.Sha256HashGenerator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Optional;


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

        try {
            boolean findResult = userService.findByEmail(userDTO);
            Optional<User> loginResult = userService.login(userDTO);

            if (!findResult) {
                ResponseManager.responseFailWithMessage(request,"존재하지 않는 메일입니다.");
            } else if (!loginResult.isPresent()) {
                ResponseManager.responseFailWithMessage(request,"비밀번호를 확인해 주세요.");
            } else {
                boolean tokenResult = userService.checkEmailToken(loginResult.get().getId());
                if (!tokenResult) {
                    ResponseManager.responseFailWithMessage(request,"회원가입 이메일 확인을 해주세요.");
                }else {
                    ResponseManager.responsePath(request,"/main.do");
                    session.setAttribute(SessionManager.SESSION_ID, loginResult.get().getId());
                    session.setAttribute(SessionManager.SESSION_EMAIL, loginResult.get().getEmail());
                    session.setAttribute(SessionManager.SESSION_NAME, loginResult.get().getName());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "/blog/pathHandler.jsp";
    }
}
