package com.blog.service;

import com.blog.DAO.CommentDAO;
import com.blog.dto.comment.CommentDTO;
import com.blog.entity.Comment;
import com.blog.entity.Post;
import com.blog.entity.User;
import com.blog.util.HibernateUtil;

import javax.persistence.EntityManager;
import javax.persistence.Query;
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
