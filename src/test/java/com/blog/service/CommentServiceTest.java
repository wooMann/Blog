package com.blog.service;

import com.blog.DAO.CommentDAO;
import com.blog.dto.comment.CommentDTO;
import com.blog.entity.Comment;
import com.blog.entity.Post;
import com.blog.entity.User;
import org.junit.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

public class CommentServiceTest {
    CommentService commentService = new CommentService();

    @Test
    public void findCommentByIdSuccess(){
        List<Comment> result =  commentService.findAllByPostId(7);

        assertTrue(result.size() > 0);
    }

    @Test
    public void findCommentByIdFail(){
        List<Comment> result =  commentService.findAllByPostId(0);

        assertTrue(result.size() <= 0);
    }


    @Test
    public void createCommentSuccess(){
        CommentDTO dto = new CommentDTO();

        dto.setBody("asdasd1111");
        dto.setPostId(7);
        dto.setUserId(24);
        Optional<Optional<Comment>> result = Optional.ofNullable(commentService.createComment(dto));
        assertTrue(result.isPresent());
    }
    @Test
    public void createCommentFail(){
        CommentDTO dto = new CommentDTO();

        dto.setBody("asdasdNONONO");

        Optional<Optional<Comment>> result = Optional.ofNullable(commentService.createComment(dto));
        assertTrue(result.isPresent());
    }

    @Test
    public void updateCommentSuccess(){
        CommentDTO dto = new CommentDTO();
        dto.setId(17);
        dto.setBody("update2");
        dto.setUserId(24);
        dto.setPostId(7);
        Comment result = commentService.updateComment(dto);
        assertEquals(result.getClass(),Comment.class);
    }
    @Test
    public void updateCommentFail(){
        CommentDTO dto = new CommentDTO();
        dto.setId(17);
        dto.setBody("update2");
        dto.setUserId(24);
        dto.setPostId(0);
        Comment result = commentService.updateComment(dto);
        assertEquals(result.getClass(),Comment.class);
    }
    @Test
    public void deleteCommentByIdSuccess(){
        boolean result = commentService.deleteById(16);
        assertTrue(result);
    }
    @Test
    public void deleteCommentByIdFail(){
        boolean result = commentService.deleteById(18181818);
        assertFalse(result);
    }
}
