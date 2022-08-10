package com.blog.service;

import com.blog.dto.user.UserDTO;
import com.blog.entity.User;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserServiceTest2 {
    UserService userService = new UserService();

    @Test
    public void joinSuccess() {
        UserDTO dto = new UserDTO();
        dto.setEmail("woo@naver.com");
        dto.setPassword("123123");
        dto.setName("우맨");
        User result = userService.join(dto);
        assertEquals(User.class, result);
    }

}