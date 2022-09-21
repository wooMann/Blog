package com.blog.controller;


import com.blog.data.dto.user.UserDTO;
import com.blog.data.entity.User;
import com.blog.manager.ResponseManager;
import com.blog.manager.SessionManager;
import com.blog.mapper.LoginMapper;
import com.blog.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Optional;


public class LoginController implements Controller {

    @Override
    public String doGet(HttpServletRequest request, HttpServletResponse response) {
        return "/blog/login.jsp";
    }

    @Override
    public String doPost(HttpServletRequest request, HttpServletResponse response) {
        UserService userService = new UserService();
        HttpSession session = request.getSession();
        UserDTO userDTO = LoginMapper.mapping(request);

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
