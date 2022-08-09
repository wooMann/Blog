package com.blog.service;

import com.blog.DAO.EmailTokenDAO;
import com.blog.dto.EmailTokensDTO;
import com.blog.entity.EmailTokens;
import com.blog.exception.ServiceException;

import java.util.logging.Level;

public class EmailTokenService{
    private EmailTokenDAO emailTokenDAO = new EmailTokenDAO();

    private EmailTokens makeEntity(EmailTokensDTO dto){
        EmailTokens emailTokens = new EmailTokens();
        emailTokens.setUserId(dto.getUserId());
        emailTokens.setToken(dto.getToken());
        emailTokens.setState(dto.getState());
        return emailTokens;
    }

    public void createEmailToken(EmailTokensDTO dto) throws ServiceException {
        if(emailTokenDAO.create(makeEntity(dto)) == null) throw new ServiceException("유저 토큰 생성 에러." , Level.WARNING);
    }
}
