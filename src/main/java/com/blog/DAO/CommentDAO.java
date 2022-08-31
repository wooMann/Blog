package com.blog.DAO;

import com.blog.entity.Comment;
import com.blog.entity.User;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;
import java.util.Optional;

public class CommentDAO extends JpaDAO<Comment>{

    public List<Comment> findAllByPostId(Integer postId) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Query query = entityManager.createNamedQuery("Comment.findByPostId")
                .setParameter("postId",postId);
        return query.getResultList();

    }

}
