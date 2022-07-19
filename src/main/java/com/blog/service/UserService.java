package com.blog.service;

import com.blog.DAO.UserDAO;
import com.blog.dto.user.UserDTO;
import com.blog.entity.User;
import com.blog.queryDAO.UserQueryDAO;
import com.blog.util.HibernateUtil;
import com.blog.util.Sha256HashGenerator;
import lombok.RequiredArgsConstructor;

import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RequiredArgsConstructor
public class UserService {
    private final HttpServletRequest request;
    private UserDAO userDAO = new UserDAO();
    private UserQueryDAO userQueryDAO = new UserQueryDAO();

    private User makeEntity(UserDTO dto) {
        User user = new User();
        user.setEmail(dto.getEmail());
        user.setPassword(Sha256HashGenerator.hashGenerate(dto.getPassword()));

        return user;
    }

    public User join(UserDTO dto) {
        User user = makeEntity(dto);
        user.setName(dto.getName());
        return userDAO.create(user);
    }

    public boolean findByEmail(UserDTO dto) {
        EntityManager entityManager = HibernateUtil.getEntityManagerFactory().createEntityManager();

        List<User> list = entityManager.createNamedQuery("User.findByEmail")
                .setParameter("email", dto.getEmail()).getResultList();
        return list.size() > 0 ? true : false;
    }

    public User login(UserDTO dto) {
        EntityManager entityManager = HibernateUtil.getEntityManagerFactory().createEntityManager();
        User user = makeEntity(dto);

        List<User> list = entityManager.createNamedQuery("User.loginCheck").
                setParameter("email", dto.getEmail()).
                setParameter("password", dto.getPassword()).
                getResultList();
        entityManager.close();
        return list.size() > 0 ? list.get(0) : null;
    }

    public User updateUser(UserDTO dto) {
        User user = makeEntity(dto);

        if (userQueryDAO.findUserByid(user.getId()) == null) {
            return null;
        } else {
            return userQueryDAO.updateUser(user);
        }
    }

    public boolean deleteUser() {
        User user = new User();
        user.setId(Integer.valueOf(request.getParameter("id")));
        user.setName(request.getParameter("name"));
        user.setPassword(request.getParameter("password"));

        if (userQueryDAO.findUserByid(user.getId()) == null) {
            return false;
        } else {
            userQueryDAO.deleteUser(user.getId());
            return true;
        }
    }

    public User findUserByEmail() {
        User user = new User();
        user.setEmail(request.getParameter("email"));
        return userQueryDAO.findUser(user);


    }
}
