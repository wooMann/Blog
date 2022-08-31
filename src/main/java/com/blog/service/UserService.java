package com.blog.service;

import com.blog.DAO.UserDAO;
import com.blog.dto.user.UserDTO;
import com.blog.entity.User;
import com.blog.queryDAO.UserQueryDAO;
import com.blog.util.HibernateUtil;
import com.blog.util.Sha256HashGenerator;
import lombok.RequiredArgsConstructor;

import javax.persistence.EntityManager;

import java.util.List;
import java.util.Optional;

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
    public Optional<User> findById(Integer id){
        return userDAO.find(User.class,id);
    }

    public List<User> findAllUser(){
        return userDAO.findAllWithNamedQuery("User.findAllUser");
    }

    public Optional<User> join(UserDTO dto) {
        User user = makeEntity(dto);
        user.setName(dto.getName());
        return userDAO.create(user);
    }

    public boolean findByEmail(UserDTO dto){
        EntityManager entityManager = HibernateUtil.getEntityManagerFactory().createEntityManager();
        List<User> list = entityManager.createNamedQuery("User.findByEmail")
                .setParameter("email", dto.getEmail()).getResultList();
        if (list.size() > 0){
            entityManager.close();
            return true;
        }else {
            entityManager.close();
            return false;
        }
    }

    public boolean checkEmailToken(Integer userId){
       Optional<User> result =  userDAO.find(User.class,userId);
       if(result.get().getEmailTokens().getAuthAt() == null) return false;
       return true;
    }

    public User login(UserDTO dto)  {
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

    public User findUserByEmail() {
        User user = new User();
        return userQueryDAO.findUser(user);
    }

    public User updateUser(UserDTO dto){
        User user = makeEntity(dto);
        user.setId(dto.getId());

        return userDAO.update(user).get();
    }

    public boolean deleteUser(UserDTO dto){
        User user = makeEntity(dto);
        user.setId(dto.getId());

        return userDAO.delete(User.class,dto.getId());
    }
}
