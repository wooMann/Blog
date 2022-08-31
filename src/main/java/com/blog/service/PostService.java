package com.blog.service;

import com.blog.DAO.CommentDAO;
import com.blog.DAO.PostDAO;
import com.blog.dto.post.PostDTO;
import com.blog.entity.Post;
import com.blog.entity.User;
import com.blog.exception.DAOException;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public class PostService {
    PostDAO postDAO = new PostDAO();

    private Post makeEntity(PostDTO dto){
        Post post = new Post();

        User user = new User();
        user.setId(dto.getUserId());

        post.setBody(dto.getBody());
        post.setTitle(dto.getTitle());
        post.setUser(user);
        return post;
    }

    public boolean createPost(PostDTO dto){
        Post post = makeEntity(dto);
        post.setCreatedAt(new Date());
        try {
            postDAO.create(post);
            return true;
        }catch (DAOException e){
            return false;
        }
    }

    public Optional<Post> updatePost(PostDTO dto){
        Post post = makeEntity(dto);
        post.setId(dto.getId());
        post.setUpdatedAt(new Date());
        try {
            return postDAO.update(post);

        }catch (DAOException e){
            return Optional.empty();
        }
    }

    public Optional<Post> findById(Integer id){
        CommentDAO commentDAO = new CommentDAO();
        Optional<Post> post = postDAO.find(Post.class,id);
        post.get().setComments(commentDAO.findAllByPostId(id));
        return post;
    }

    public List<Post> finaAllPost(){
       return postDAO.findAllWithNamedQuery("Post.findAll");
    }


}
