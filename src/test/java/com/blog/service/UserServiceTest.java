package com.blog.service;

import com.blog.dto.user.UserDTO;
import com.blog.entity.User;
import com.blog.exception.ServiceException;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserServiceTest {

    UserService userService = new UserService();

    @Test
    public void joinSuccess() {
        UserDTO dto = new UserDTO();
        dto.setEmail("woo@naver.com");
        dto.setPassword("123123");
        dto.setName("우맨");
        User result = userService.join(dto);
        assertNotEquals(dto, result);
        assertEquals(User.class , result.getClass());
    }

    @Test
    public void joinFail() {
        UserDTO dto = new UserDTO();
        dto.setEmail("");
        dto.setPassword("");
        dto.setName("우맨");
        User result = userService.join(dto);
        assertEquals(User.class, result);
    }

    @Test
    public void findByEmailSuccess() {
        UserDTO dto = new UserDTO();
        dto.setEmail("woo@naver.com");
        try {
            boolean result = userService.findByEmail(dto);
            assertTrue(result);
        }catch (ServiceException e){
            e.printStackTrace();
        }

    }
    @Test
    public void findByEmailFail() {
        UserDTO dto = new UserDTO();
        dto.setEmail("woo@naver11.comp");
        try {
            boolean result = userService.findByEmail(dto);
            assertFalse(result);
        }catch (ServiceException e){
            e.printStackTrace();
        }
    }
    @Test
    public void loginSuccess() {
        UserDTO dto = new UserDTO();
        dto.setEmail("12");
        dto.setPassword("12");
        User result = userService.login(dto);
        assertEquals(User.class, result.getClass());
        assertEquals(dto.getEmail(),result.getEmail());
    }

    @Test
    public void loginFail() {
        UserDTO dto = new UserDTO();
        dto.setEmail("woo@naver.com");
        dto.setPassword("12312312fgv1v");
        User result = userService.login(dto);
        assertNull(result);
    }


}