package com.service;

import com.entity.User;
import com.queryDAO.UserQueryDAO;

import javax.servlet.http.HttpServletRequest;


public class MainService {
    private final HttpServletRequest request;
    private UserQueryDAO userQueryDAO = new UserQueryDAO();

    public MainService(HttpServletRequest request) {
        this.request = request;
    }

    public User join(){
        User user = new User();
        user.setEmail(request.getParameter("email"));
        user.setPassword(request.getParameter("password"));
        user.setName(request.getParameter("name"));
        return userQueryDAO.joinUser(user);
    }

    public User login(){
        User user = new User();
        user.setEmail(request.getParameter("email"));
        user.setPassword(request.getParameter("password"));
        if(userQueryDAO.findUser(user) == null){
            return null;
        }else {
            return userQueryDAO.login(user);
        }
    }

    public User updateUser(){
        User user = new User();
        user.setId(Integer.valueOf(request.getParameter("id")));
        user.setName(request.getParameter("name"));
        user.setPassword(request.getParameter("password"));

        if (userQueryDAO.findUserByid(user.getId()) == null){
            return null;
        }else {
            return userQueryDAO.updateUser(user);
        }
    }

    public boolean deleteUser(){
        User user = new User();
        user.setId(Integer.valueOf(request.getParameter("id")));
        user.setName(request.getParameter("name"));
        user.setPassword(request.getParameter("password"));

        if (userQueryDAO.findUserByid(user.getId()) == null){
            return false;
        }else {
            userQueryDAO.deleteUser(user.getId());
            return true;
        }
    }

    public User findUserByEmail(){
        User user = new User();
        user.setEmail(request.getParameter("email"));
        return userQueryDAO.findUser(user);


    }
}
