package com.blog.controller.user;

import com.blog.controller.Controller;
import com.blog.manager.ResponseManager;
import com.blog.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserDeleteController implements Controller {
    @Override
    public String doGet(HttpServletRequest request, HttpServletResponse response) {
        return null;
    }

    @Override
    public String doPost(HttpServletRequest request, HttpServletResponse response) {
        UserService userService = new UserService();
        Integer id = Integer.valueOf(request.getParameter("id"));

        ResponseManager.responsePath(request,"/main.do");
        return "/blog/pathHandler.jsp";
    }
}
