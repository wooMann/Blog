package com.blog.data.DAO;

import com.blog.data.entity.Comment;
import com.blog.data.entity.User;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class CommentDAO extends JpaDAO<Comment>{

    public List<Comment> findAllByPostId(Integer postId) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Query query = entityManager.createNamedQuery("Comment.findByPostId")
                .setParameter("postId",postId);
        return query.getResultList();

    }

}
