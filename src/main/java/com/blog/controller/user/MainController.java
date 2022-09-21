package com.blog.controller.user;

import com.blog.controller.Controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MainController implements Controller {

    @Override
    public String doGet(HttpServletRequest request, HttpServletResponse response) {
        return "/blog/main.jsp";
    }

    @Override
    public String doPost(HttpServletRequest request, HttpServletResponse response) {
        return null;
    }


}
