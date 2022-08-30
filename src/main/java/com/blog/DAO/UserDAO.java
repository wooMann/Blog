package com.blog.DAO;

import com.blog.entity.User;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.Optional;

public class UserDAO extends JpaDAO<User>{


    public Optional<User> findByEmail(String email) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Query query = entityManager.createNamedQuery("User.findByEmail")
                .setParameter("email",email);
        return Optional.ofNullable((User) query.getSingleResult());

    }
}
