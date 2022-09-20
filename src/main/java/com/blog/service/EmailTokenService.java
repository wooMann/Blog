package com.blog.service;

import com.blog.data.DAO.EmailTokenDAO;
import com.blog.data.dto.EmailTokensDTO;
import com.blog.data.entity.EmailTokens;
import com.blog.data.entity.User;
import com.blog.exception.DAOException;
import com.blog.exception.ServiceException;
import org.apache.log4j.Level;




public class EmailTokenService {
    private EmailTokenDAO emailTokenDAO = new EmailTokenDAO();

    private EmailTokens makeEntity(EmailTokensDTO dto) {
        User user = new User();
        user.setId(dto.getUserId());

        EmailTokens emailTokens = new EmailTokens();
        emailTokens.setUser(user);
        emailTokens.setToken(dto.getToken());
        emailTokens.setState(dto.getState());
        return emailTokens;
    }

    public void createEmailToken(EmailTokensDTO dto) throws ServiceException {
                if (!emailTokenDAO.create(makeEntity(dto)).isPresent()) throw new ServiceException("유저 토큰 생성 에러." + dto.toString(), Level.INFO);
    }

    public void updateEmailToken(EmailTokensDTO dto) throws DAOException {
       emailTokenDAO.emailTokenUpdate(dto);
    }
}
