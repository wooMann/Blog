package com.blog.controller.emailTokens;

import com.blog.controller.Controller;
import com.blog.dto.EmailTokensDTO;
import com.blog.exception.ServiceException;
import com.blog.service.EmailTokenService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import java.io.IOException;
import java.util.Date;

public class JoinConfirmController implements Controller {
    @Override
    public String httpMethod() {
        return "GET";
    }


    @Transactional
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EmailTokenService emailTokenService = new EmailTokenService();
        try {
            emailTokenService.updateEmailToken(makeDTO(request));
            request.setAttribute("path","/login.do");
            request.setAttribute("message","회원가입이 완료되었습니다.");
        }catch (ServiceException e){
            request.setAttribute("path","javascript:history.back()");
            request.setAttribute("message","회원가입 완료처리중 에러.");
        }catch (Exception e){
            e.printStackTrace();
        }
        return "/blog/pathHandler.jsp";
    }

    private EmailTokensDTO makeDTO(HttpServletRequest request){
        EmailTokensDTO dto = new EmailTokensDTO();
        dto.setToken(request.getParameter("token"));
        dto.setAuthAt(new Date());
        dto.setState(1);

        return dto;
    }
}
