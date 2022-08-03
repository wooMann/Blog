package com.blog.service;

import com.blog.dto.user.UserDTO;
import com.blog.entity.User;
import com.blog.exception.FindByEmailServiceException;
import com.blog.exception.LoginServiceException;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserServiceTest {

    UserService userService = new UserService();

    private UserDTO userDTO() {
        UserDTO dto = new UserDTO();
        dto.setEmail("woo@naver.com");
        dto.setPassword("123123");
        dto.setName("우맨");
        return dto;
    }

    @Test
    public void join() {
        User result = userService.join(userDTO());
        assertEquals(User.class, result);
    }

    @Test
    public void findByEmail() {
        try {
            boolean result = userService.findByEmail(userDTO());
            assertEquals(Boolean.class, result);
        } catch (FindByEmailServiceException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void login() {
        try {
            User result = userService.login(userDTO());
            assertEquals(User.class, result);
        } catch (LoginServiceException e) {
            e.printStackTrace();
        }
    }


}