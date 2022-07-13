package com.controller;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class JoinController implements Controller {
    @Override
    public String httpMethod() {
        return "GET";
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        return "/posts/join.jsp";
    }
}
