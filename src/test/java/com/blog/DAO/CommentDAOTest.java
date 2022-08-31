package com.blog.DAO;

import com.blog.entity.Comment;
import com.blog.entity.Post;
import com.blog.entity.User;
import org.junit.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;
public class CommentDAOTest {
    CommentDAO commentDAO = new CommentDAO();

    @Test
    public void findCommentByIdSuccess(){
        Optional<Comment> result =  commentDAO.find(Comment.class,1);

        assertEquals(result.get().getClass(),Comment.class);
    }

    @Test
    public void findCommentByIdFail(){
        Optional<Comment> result =  commentDAO.find(Comment.class,00);

        assertEquals(result.get().getClass(),Comment.class);
    }


    @Test
    public void createCommentSuccess(){
        Comment comment = new Comment();
        Post post = new Post();
        post.setId(7);
        User user = new User();
        user.setId(24);

        comment.setBody("asdasd1111");
        comment.setPost(post);
        Optional<Optional<Comment>> result = Optional.ofNullable(commentDAO.create(comment));
        assertTrue(result.isPresent());
    }
    @Test
    public void createCommentFail(){
        Comment comment = new Comment();
        Post post = new Post();
        post.setId(9);
        User user = new User();
        user.setId(0);

        comment.setBody("asdasd222");
        comment.setPost(post);
        Optional<Optional<Comment>> result = Optional.ofNullable(commentDAO.create(comment));
        assertFalse(result.isPresent());
    }

    @Test
    public void updateCommentSuccess(){
        Comment comment = new Comment();
        Post post = new Post();
        post.setId(7);
        User user = new User();
        user.setId(24);

        comment.setId(17);
        comment.setBody("update2");
        comment.setUser(user);
        comment.setPost(post);
        Optional<Optional<Comment>> result = Optional.ofNullable(commentDAO.update(comment));
        assertTrue(result.isPresent());
    }
    @Test
    public void updateCommentFail(){
        Comment comment = new Comment();
        Post post = new Post();
        post.setId(9);
        User user = new User();
        user.setId(0);

        comment.setBody("updatefail2");
        comment.setPost(post);
        Optional<Optional<Comment>> result = Optional.ofNullable(commentDAO.update(comment));
        assertFalse(result.isPresent());
    }

    @Test
    public void findAllCommentByPostIdSuccess(){
        Integer postId = 7;
        List<Comment> result = commentDAO.findAllByPostId(postId);
        assertTrue(result.size() > 0);
        assertEquals(result.get(0).getPost().getId(),postId);
    }

    @Test
    public void findAllCommentByPostIdFail(){
        Integer postId = 8;
        List<Comment> result = commentDAO.findAllByPostId(postId);
        assertTrue(result.size() <= 0);
    }

    @Test
    public void deleteCommentByIdSuccess(){
        boolean result = commentDAO.delete(Comment.class,18);
        assertTrue(result);
    }
    @Test
    public void deleteCommentByIdFail(){
        boolean result = commentDAO.delete(Comment.class,17);
        assertFalse(result);
    }
}
