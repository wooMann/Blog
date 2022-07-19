package com.blog.controller;


import com.blog.dto.LogoutDTO;

import javax.servlet.ServletException;
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
