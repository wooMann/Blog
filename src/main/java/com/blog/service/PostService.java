package com.blog.service;

import com.blog.DAO.CommentDAO;
import com.blog.DAO.PostDAO;
import com.blog.dto.post.PostDTO;
import com.blog.entity.Post;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public class PostService {
    PostDAO postDAO = new PostDAO();


    public Optional<Post> createPost(PostDTO dto){
        Post post = dto.makePost();
        post.setCreatedAt(new Date());
        return postDAO.create(post);
    }

    public Optional<Post> updatePost(PostDTO dto){
        Post post = dto.makePost();
        post.setId(dto.getId());
        post.setUpdatedAt(new Date());
        return postDAO.update(post);
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
