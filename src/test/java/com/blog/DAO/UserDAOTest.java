package com.blog.DAO;

import com.blog.entity.User;
import com.blog.util.Sha256HashGenerator;
import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.*;
public class UserDAOTest {
    UserDAO userDAO = new UserDAO();

    @Test
    public void findByEmailSuccess(){
        String email = "woo@naver.com";
        Optional<User> result =  userDAO.findByEmail(email);
        assertTrue(result.isPresent());
    }

    @Test
    public void findByEmailFail(){
        String email = "woo@naver.commmmmm";
        Optional<User> result =  userDAO.findByEmail(email);
        assertFalse(result.isPresent());
    }

    @Test
    public void createUserSuccess(){
        User user = new User();
        user.setEmail("wooDAO@gmail.com");
        user.setPassword(Sha256HashGenerator.hashGenerate("1234"));
        user.setName("DAO");

        Optional<User> result = userDAO.create(user);
        assertEquals(User.class,result.getClass());
        assertEquals(result.get().getEmail(),user.getEmail());
    }

    @Test
    public void createUserFail(){
        User user = new User();
        user.setEmail("wooDAO@gmail.com");
        user.setName("DAO");
        userDAO.create(user);
    }

    @Test
    public void updateUserSuccess(){
        User user = new User();
        user.setId(34);
        user.setEmail("wooDAO@gmail.com");
        user.setPassword(Sha256HashGenerator.hashGenerate("1234"));
        user.setName("DAOChange");

        User result = userDAO.update(user);
        assertEquals(User.class,result.getClass());
        assertEquals(result.getEmail(),user.getEmail());
    }

    @Test
    public void updateUserFail(){
        User user = new User();
        user.setEmail("wooDAO@gmail.com");
        user.setName("DAO");

        userDAO.update(user);
    }

    @Test
    public void deleteUserByIdSuccess(){
        User user = new User();
        user.setId(34);

        boolean result = userDAO.delete(User.class,user.getId());
        assertTrue(result);
    }

    @Test
    public void deleteUserByIdFail(){
        User user = new User();
        user.setId(34);

        boolean result = userDAO.delete(User.class,user.getId());
        assertFalse(result);
    }


}
