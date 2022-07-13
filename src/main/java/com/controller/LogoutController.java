package com.controller;


import com.dto.LogoutDTO;
import com.service.AuthService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class LogoutController implements Controller {


    public void action(){
        //세션에 저장된 정보
        LogoutDTO logoutDTO = new LogoutDTO();
        logoutDTO.setUserId(1);

    }

    @Override
    public String httpMethod() {
        return "GET";
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        return null;
    }
}
