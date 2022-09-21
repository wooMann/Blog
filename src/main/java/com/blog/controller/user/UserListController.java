package com.blog.controller.user;

import com.blog.controller.Controller;
import com.blog.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserListController implements Controller {

    @Override
    public String doGet(HttpServletRequest request, HttpServletResponse response) {
        UserService userService = new UserService();
        request.setAttribute("userList",userService.findAllUser());
        return "/blog/user/userList.jsp";
    }

    @Override
    public String doPost(HttpServletRequest request, HttpServletResponse response) {
        return null;
    }


}
