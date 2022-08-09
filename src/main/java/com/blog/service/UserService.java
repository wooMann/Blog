package com.blog.service;

import com.blog.DAO.UserDAO;
import com.blog.dto.user.UserDTO;
import com.blog.entity.User;
import com.blog.exception.FindByEmailServiceException;
import com.blog.exception.LoginServiceException;
import com.blog.queryDAO.UserQueryDAO;
import com.blog.util.HibernateUtil;
import com.blog.util.Sha256HashGenerator;
import lombok.RequiredArgsConstructor;

import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.logging.Level;

@RequiredArgsConstructor
public class UserService {

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

    public boolean findByEmail(UserDTO dto) throws FindByEmailServiceException {
        EntityManager entityManager = HibernateUtil.getEntityManagerFactory().createEntityManager();
        boolean result = false;
        List<User> list = entityManager.createNamedQuery("User.findByEmail")
                .setParameter("email", dto.getEmail()).getResultList();
        if (list.size() > 0){
            return true;
        }else {
            throw new FindByEmailServiceException("존재하지 않는 이메일 : " + dto.toString(),Level.INFO);
        }
    }

    public User login(UserDTO dto) throws LoginServiceException {
        EntityManager entityManager = HibernateUtil.getEntityManagerFactory().createEntityManager();

        List<User> list = entityManager.createNamedQuery("User.loginCheck").
                setParameter("email", dto.getEmail()).
                setParameter("password", dto.getPassword()).
                getResultList();
        entityManager.close();
        if(list.size() > 0){
            return list.get(0);
        }else {
            throw new LoginServiceException("비밀번호가 틀렸습니다."+ dto.toString(), Level.INFO);
        }
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

        if (userQueryDAO.findUserByid(user.getId()) == null) {
            return false;
        } else {
            userQueryDAO.deleteUser(user.getId());
            return true;
        }
    }

    public User findUserByEmail() {
        User user = new User();
        return userQueryDAO.findUser(user);
    }
}
