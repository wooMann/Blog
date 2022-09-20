package com.blog.data.DAO;

import com.blog.data.dto.EmailTokensDTO;
import com.blog.data.entity.EmailTokens;
import com.blog.exception.DAOException;
import com.blog.util.HibernateUtil;
import org.apache.log4j.Level;

import javax.persistence.EntityManager;

public class EmailTokenDAO extends JpaDAO<EmailTokens>{

    public void emailTokenUpdate(EmailTokensDTO dto) throws DAOException{
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
            throw new DAOException("이메일 토큰 업데이트 실패." + dto.toString(), Level.ERROR);
        }
    }
}
