package com.blog.DAO;

import com.blog.entity.Post;
import com.blog.entity.User;
import org.junit.Test;

import java.util.List;
import java.util.Optional;
import static org.junit.Assert.*;
public class PostDAOTest {
    PostDAO postDAO = new PostDAO();

    @Test
    public void createPostSuccess(){
        Post post = new Post();

        post.setTitle("tittiti");
        post.setBody("boddddd");

        User user = new User();
        user.setId(24);
        post.setUser(user);

        Optional<Post> result =  postDAO.create(post);
        assertTrue(result.isPresent());
    }

    @Test
    public void createPostFail(){
        Post post = new Post();

        post.setBody("fail");

        User user = new User();
        user.setId(24);
        post.setUser(user);

        Optional<Post> result =  postDAO.create(post);
        assertTrue(result.isPresent());
    }

    @Test
    public void updatePostSuccess(){
        Post post = new Post();

        post.setId(10);
        post.setTitle("upda");
        post.setBody("updadddd");

        User user = new User();
        user.setId(24);
        post.setUser(user);

        Optional<Post> result =  postDAO.update(post);
        assertTrue(result.isPresent());
    }

    @Test
    public void updatePostFail(){
        Post post = new Post();

        post.setTitle("upda");
        post.setBody("updadddd");

        User user = new User();
        user.setId(24);
        post.setUser(user);

        Optional<Post> result =  postDAO.update(post);
        assertTrue(result.isPresent());
    }

    @Test
    public void deletePostSuccess(){
        boolean result =  postDAO.delete(Post.class,11);
        assertTrue(result);
    }

    @Test
    public void deletePostFail(){
        boolean result =  postDAO.delete(Post.class,11);
        assertFalse(result);
    }

    @Test
    public void findAllPost(){
        List<Post> result =  postDAO.findAllWithNamedQuery("Post.findAll");
        assertTrue(result.size() > 0);
    }
}
