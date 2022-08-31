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

    private Comment makeEntity(CommentDTO dto){
        Comment comment = new Comment();
        comment.setBody(dto.getBody());

        Post post = new Post();
        post.setId(dto.getPostId());
        comment.setPost(post);

        if(dto.getUserId() != null){
            User user = new User();
            user.setId(dto.getUserId());
            comment.setUser(user);
        }

        comment.setUserIp(dto.getUserIp());

        return comment;
    }

    public Optional<Comment> createComment(CommentDTO dto){
        return commentDAO.create(makeEntity(dto));
    }
    public Comment updateComment(CommentDTO dto){
        Comment comment = makeEntity(dto);
        comment.setUserIp(dto.getUserIp());
        comment.setId(dto.getCommentId());

        return commentDAO.update(comment).get();
    }
    public List<Comment> findAllByPostId(Integer postId){
        EntityManager entityManager = HibernateUtil.getEntityManagerFactory().createEntityManager();
        Query query = entityManager.createNamedQuery("Comment.findByPostId").setParameter(postId,postId);
        return query.getResultList();
    }

    public boolean deleteById(Integer id){
        return commentDAO.delete(Comment.class,id);
    }
}
