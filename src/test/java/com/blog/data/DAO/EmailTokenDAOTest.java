package com.blog.data.DAO;

import com.blog.data.entity.EmailTokens;
import com.blog.data.entity.User;
import org.junit.Test;

import java.util.Date;
import java.util.Optional;

import static org.junit.Assert.*;

public class EmailTokenDAOTest {
    EmailTokenDAO emailTokenDAO = new EmailTokenDAO();

    @Test
    public void findEmailTokenSuccess(){
        Optional<EmailTokens> result = emailTokenDAO.find(EmailTokens.class,10);
        assertTrue(result.isPresent());
    }

    @Test
    public void findEmailTokenFail(){
        Optional<EmailTokens> result = emailTokenDAO.find(EmailTokens.class,0);
        assertFalse(result.isPresent());
    }

    @Test
    public void createEmailTokenSuccess(){
        EmailTokens emailTokens = new EmailTokens();

        User user = new User();
        user.setId(24);
        emailTokens.setUser(user);
        emailTokens.setToken("19de839a");
        emailTokens.setState(0);

        Optional<EmailTokens> result = emailTokenDAO.create(emailTokens);
        assertTrue(result.isPresent());
        assertEquals(emailTokens.getToken(),result.get().getToken());
    }

    @Test
    public void createEmailTokenFail(){
        EmailTokens emailTokens = new EmailTokens();

        User user = new User();
        user.setId(0);
        emailTokens.setUser(user);
        emailTokens.setToken("");
        emailTokens.setState(0);

        Optional<EmailTokens> result = emailTokenDAO.create(emailTokens);
        assertFalse(result.isPresent());
        assertNotEquals(emailTokens.getToken(),result.get().getToken());
    }

    @Test
    public void updateEmailTokenSuccess(){
        EmailTokens emailTokens = new EmailTokens();

        emailTokens.setId(15);
        emailTokens.setAuthAt(new Date());
        emailTokens.setState(1);

        Optional<EmailTokens> result = emailTokenDAO.update(emailTokens);
        assertTrue(result.isPresent());
        assertEquals(result.get().getId(),emailTokens.getId());

    }

    @Test
    public void updateEmailTokenFail(){
        EmailTokens emailTokens = new EmailTokens();

        emailTokens.setId(6354654);
        emailTokens.setAuthAt(new Date());
        emailTokens.setState(1);

        Optional<EmailTokens> result = emailTokenDAO.update(emailTokens);
        assertFalse(result.isPresent());
        assertNotEquals(result.get().getId(),emailTokens.getId());



    }



}