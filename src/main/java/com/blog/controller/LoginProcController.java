package com.blog.controller;


import com.blog.entity.User;
import com.blog.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


public class LoginProcController implements Controller {


    @Override
    public String httpMethod() {
        return "GET";
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserService userService = new UserService(request);
        HttpSession session = request.getSession();
        User result = userService.login();

        if (result == null) {
            session.setAttribute("path", "/login.do");
            session.setAttribute("message","로그인실패");
            return "/posts/pathHandler.jsp";
        }
        session.setAttribute("SESSION_USER_EMAIL",result.getEmail());
        session.setAttribute("SESSION_USER_NAME",result.getName());
        return "/posts/main.jsp";
    }
}
