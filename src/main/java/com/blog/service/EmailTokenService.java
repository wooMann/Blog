package com.blog.service;

import com.blog.DAO.EmailTokenDAO;
import com.blog.dto.EmailTokensDTO;
import com.blog.entity.EmailTokens;
import com.blog.entity.User;
import com.blog.exception.ServiceException;
import com.blog.util.HibernateUtil;
import org.apache.log4j.Level;

import javax.persistence.EntityManager;


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
        System.out.println(dto);
        if (emailTokenDAO.create(makeEntity(dto)) == null) throw new ServiceException("유저 토큰 생성 에러." + dto.toString(), Level.INFO);
    }

    public void updateEmailToken(EmailTokensDTO dto) throws ServiceException {
        EntityManager entityManager = HibernateUtil.getEntityManagerFactory().createEntityManager();
        try {
            entityManager.getTransaction().begin();
                    entityManager.createNamedQuery("EmailTokens.updateEmailTokensByTokens").
                    setParameter("authat", dto.getAuthAt()).
                    setParameter("state", dto.getState()).
                    setParameter("token", dto.getToken()).
                    executeUpdate();
            entityManager.getTransaction().commit();
            entityManager.close();
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
            throw new ServiceException("이메일 토큰 업데이트 실패." + dto.toString(),Level.ERROR);
        }

    }
}
