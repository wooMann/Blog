package com.controller;


import com.entity.User;
import com.service.MailService;
import com.service.MainService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;


public class JoinProcController implements Controller {
    @Override
    public String httpMethod() {
        return "POST";
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        MainService mainService = new MainService(request);
        MailService mailService = new MailService();
        UUID uuid = UUID.randomUUID();
        String code[] = String.valueOf(uuid).split("-");

        User findResult = mainService.findUserByEmail();
        if (findResult == null){
            User joinResult = mainService.join();
            if(joinResult == null){
                request.setAttribute("path","/login.do");
                request.setAttribute("message","회원가입 실패.");
                return "/posts/pathHandler.jsp";
            }
            request.setAttribute("path","/login.do");
            request.setAttribute("message","회원가입 확인 이메일이 전송되었습니다.");
            mailService.sendMail(joinResult,code[0]);

        }else {
            request.setAttribute("path","javascript:history.back()");
            request.setAttribute("message","이미 존재하는 메일명.");
        }
        return "/posts/pathHandler.jsp";
    }
}
