package com.blog.service;

import com.blog.data.dto.user.UserDTO;
import com.blog.data.entity.User;
import com.blog.exception.ServiceException;
import com.blog.util.Sha256HashGenerator;
import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.*;

public class UserServiceTest {

    UserService userService = new UserService();

    @Test
    public void joinSuccess() {
        UserDTO dto = new UserDTO();
        System.out.println(Sha256HashGenerator.hashGenerate("123"));
      /*  dto.setEmail("wookw123@naver.com");
        dto.setPassword("123123");
        dto.setName("우맨");
        Optional<User> result = userService.join(dto);
        assertNotEquals(dto, result);
        assertEquals(User.class , result.get().getClass());*/
    }

    @Test
    public void joinFail() {
        UserDTO dto = new UserDTO();
        dto.setEmail("");
        dto.setPassword("");
        dto.setName("우맨");
        Optional<User> result = userService.join(dto);
        assertEquals(User.class, result.get().getClass());
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
        dto.setEmail("123");
        dto.setPassword("123");
        Optional<User> result = userService.login(dto);
        assertEquals(User.class, result.getClass());
        assertEquals(dto.getEmail(),result.get().getEmail());
    }

    @Test
    public void loginFail() {
        UserDTO dto = new UserDTO();
        dto.setEmail("woo@naver.com");
        dto.setPassword("12312312fgv1v");
        Optional<User> result = userService.login(dto);
        assertFalse(result.isPresent());
    }


}