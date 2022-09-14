package com.blog.DAO;

import com.blog.dto.user.UserDTO;
import com.blog.entity.User;
import com.blog.util.HibernateUtil;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;
import java.util.Optional;

public class UserDAO extends JpaDAO<User>{


    public Optional<User> findByEmail(String email) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        List<User> result = entityManager.createNamedQuery("User.findByEmail")
                .setParameter("email",email).getResultList();
        return result.size() > 0 ? Optional.ofNullable(result.get(0)) : Optional.empty();

    }

    public Optional<User> login(UserDTO dto){
        User user = dto.makeUser();
        EntityManager entityManager = HibernateUtil.getEntityManagerFactory().createEntityManager();

        List<User> result = entityManager.createNamedQuery("User.loginCheck").
                setParameter("email", user.getEmail()).
                setParameter("password", user.getPassword()).
                getResultList();
        entityManager.close();

        return result.size() > 0 ? Optional.ofNullable(result.get(0)) : Optional.empty();
    }

    public User login2(UserDTO dto){
        EntityManager entityManager = HibernateUtil.getEntityManagerFactory().createEntityManager();

        List<User> list = entityManager.createNamedQuery("User.loginCheck").
                setParameter("email", dto.getEmail()).
                setParameter("password", dto.getPassword()).
                getResultList();
        entityManager.close();
        if(list.size() > 0){
            entityManager.close();
            return list.get(0);
        }else {
            entityManager.close();
            return null;
        }
    }


}
