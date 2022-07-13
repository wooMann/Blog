package com.controller;


import com.entity.User;
import com.service.MainService;

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
        MainService mainService = new MainService(request);
        HttpSession session = request.getSession();
        User result = mainService.login();

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
