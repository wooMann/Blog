package com.blog.service;

import com.blog.DAO.CommentDAO;
import com.blog.dto.comment.CommentDTO;
import com.blog.entity.Comment;
import com.blog.entity.Post;
import com.blog.entity.User;
import javafx.geometry.Pos;

public class CommentService {
    CommentDAO commentDAO = new CommentDAO();

    private Comment makeEntity(CommentDTO dto){
        Comment comment = new Comment();
        comment.setBody(dto.getBody());

        Post post = new Post();
        post.setId(dto.getPostId());
        comment.setPost(post);

        User user = new User();
        user.setId(dto.getUserId());
        comment.setUser(user);
        comment.setUserIp(dto.getUserIp());

        return comment;
    }

    public Comment createComment(CommentDTO dto){
        return commentDAO.create(makeEntity(dto));
    }
}
