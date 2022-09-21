package com.blog.controller.emailTokens;

import com.blog.controller.Controller;
import com.blog.data.dto.EmailTokensDTO;
import com.blog.exception.DAOException;
import com.blog.manager.ResponseManager;
import com.blog.mapper.JoinConfirmMapper;
import com.blog.service.EmailTokenService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import java.io.IOException;
import java.util.Date;

public class JoinConfirmController implements Controller {

    @Override
    public String doGet(HttpServletRequest request, HttpServletResponse response) {
        EmailTokenService emailTokenService = new EmailTokenService();
        try {
            emailTokenService.updateEmailToken(JoinConfirmMapper.mapping(request));
            ResponseManager.responseFailWithMessageAndPath(request,"회원가입이 완료되었습니다.","/login.do");
        }catch (DAOException e){
            ResponseManager.responseFailWithMessage(request,"회원가입 완료처리중 에러.");
        }catch (Exception e){
            e.printStackTrace();
        }
        return "/blog/pathHandler.jsp";
    }

    @Override
    public String doPost(HttpServletRequest request, HttpServletResponse response) {
        return null;
    }


}
