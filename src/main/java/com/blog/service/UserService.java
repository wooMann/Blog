package com.blog.service;

import com.blog.DAO.UserDAO;
import com.blog.dto.user.UserDTO;
import com.blog.entity.User;
import lombok.RequiredArgsConstructor;



import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class UserService {

    private UserDAO userDAO = new UserDAO();

    public Optional<User> findById(Integer id){
        return userDAO.find(User.class,id);
    }

    public List<User> findAllUser(){
        return userDAO.findAllWithNamedQuery("User.findAllUser");
    }

    public Optional<User> join(UserDTO dto) {
        User user = dto.makeUser();
        user.setName(dto.getName());
        return userDAO.create(user);
    }

    public boolean findByEmail(UserDTO dto){
        Optional<User> result =  userDAO.findByEmail(dto.getEmail());
        return result.isPresent() ? true : false;
    }

    public boolean checkEmailToken(Integer userId){
       Optional<User> result =  userDAO.find(User.class,userId);
       if(result.get().getEmailTokens().getAuthAt() == null) return false;
       return true;
    }

    public Optional<User> login(UserDTO dto)  {
       return userDAO.login(dto);
    }

    public User findUserByEmail(UserDTO dto) {

        return userDAO.findByEmail(dto.getEmail()).get();
    }

    public Optional<User> updateUser(UserDTO dto){
        User user = dto.makeUser();
        user.setId(dto.getId());
        return userDAO.update(user);
    }

    public boolean deleteUser(UserDTO dto){
        User user = dto.makeUser();
        user.setId(dto.getId());

        return userDAO.delete(User.class,dto.getId());
    }
}
