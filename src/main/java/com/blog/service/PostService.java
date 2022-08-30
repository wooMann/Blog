package com.blog.service;

import com.blog.DAO.PostDAO;
import com.blog.dto.post.PostDTO;
import com.blog.entity.Post;
import com.blog.entity.User;
import com.blog.exception.DAOException;

import java.util.List;
import java.util.Optional;

public class PostService {
    PostDAO postDAO = new PostDAO();

    private Post makeEntity(PostDTO dto){
        Post post = new Post();

        User user = new User();
        user.setId(dto.getId());

        post.setBody(dto.getBody());
        post.setTitle(dto.getTitle());
        post.setUser(user);
        return post;
    }

    public boolean createPost(PostDTO dto){
        Post post = makeEntity(dto);
        try {
            postDAO.create(post);
            return true;
        }catch (DAOException e){
            return false;
        }
    }

    public Post updatePost(PostDTO dto){
        Post post = makeEntity(dto);
        post.setId(dto.getPostId());
        return postDAO.update(post);
    }

    public Optional<Post> findById(Integer id){
        return postDAO.find(Post.class,id);
    }

    public List<Post> finaAllPost(){
       return postDAO.findAllWithNamedQuery("Post.findAll");
    }


}
