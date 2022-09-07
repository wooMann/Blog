package com.blog.service;

import com.blog.dto.EmailTokensDTO;
import com.blog.exception.ServiceException;
import org.junit.Test;

import javax.xml.ws.Service;

import java.util.Date;

import static org.junit.Assert.*;

public class EmailTokenServiceTest {

    EmailTokenService emailTokenService = new EmailTokenService();

    @Test
    public void createEmailTokenSuccess() {
        EmailTokensDTO dto = new EmailTokensDTO();
        dto.setUserId(24);
        dto.setToken("djdjd11d");
        dto.setState(0);
        emailTokenService.createEmailToken(dto);
    }

    @Test(expected = ServiceException.class)
    public void createEmailTokenFail() {
        EmailTokensDTO dto = new EmailTokensDTO();
        dto.setUserId(0);
        dto.setState(4653);
        emailTokenService.createEmailToken(dto);
    }

    @Test
    public void updateEmailTokenSuccess() {
        EmailTokensDTO dto = new EmailTokensDTO();
        dto.setToken("djdjd11d");
        dto.setAuthAt(new Date());
        dto.setState(1);

        emailTokenService.updateEmailToken(dto);
    }

    @Test(expected = ServiceException.class)
    public void updateEmailTokenFail() {
        EmailTokensDTO dto = new EmailTokensDTO();
        dto.setToken("");
        dto.setAuthAt(new Date());
        dto.setState(1);

        emailTokenService.updateEmailToken(dto);
    }
}