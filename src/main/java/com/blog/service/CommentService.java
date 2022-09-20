package com.blog.service;

import com.blog.data.DAO.CommentDAO;
import com.blog.data.dto.comment.CommentDTO;
import com.blog.data.entity.Comment;
import com.blog.data.entity.Post;
import com.blog.data.entity.User;

import java.util.List;
import java.util.Optional;

public class CommentService {
    CommentDAO commentDAO = new CommentDAO();



    public Optional<Comment> createComment(CommentDTO dto){
        return commentDAO.create(dto.makeComment());
    }
    public Comment updateComment(CommentDTO dto){
        Comment comment = dto.makeComment();
        comment.setUserIp(dto.getUserIp());
        comment.setId(dto.getCommentId());

        return commentDAO.update(comment).get();
    }
    public List<Comment> findAllByPostId(Integer postId){
        return commentDAO.findAllByPostId(postId);
    }

    public boolean deleteById(Integer id){
        return commentDAO.delete(Comment.class,id);
    }
}
