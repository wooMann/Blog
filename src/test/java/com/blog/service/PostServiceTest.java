package com.blog.service;

import com.blog.data.dto.post.PostDTO;
import com.blog.data.entity.Post;
import com.blog.data.entity.User;
import org.junit.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;
public class PostServiceTest {
    PostService postService = new PostService();
    @Test
    public void createPostSuccess(){
        PostDTO dto = new PostDTO();

        dto.setTitle("uuuuuuu");
        dto.setBody("uuuuuu");

        dto.setUserId(24);

        boolean result =  postService.createPost(dto).isPresent();
        assertTrue(result);
    }

    @Test
    public void createPostFail(){
        PostDTO dto = new PostDTO();

        dto.setTitle("uuuuuuu");
        dto.setBody("uuuuuu");

        dto.setUserId(24);

        boolean result =  postService.createPost(dto).isPresent();
        assertTrue(result);
    }

    @Test
    public void updatePostSuccess(){
        PostDTO dto = new PostDTO();

        dto.setId(10);
        dto.setTitle("upda");
        dto.setBody("updadddd");
        dto.setUserId(24);

        Optional<Post> result =  postService.updatePost(dto);
        assertTrue(result.isPresent());
    }

    @Test
    public void updatePostFail(){
        PostDTO dto = new PostDTO();

        dto.setId(0);
        dto.setTitle("upda");
        dto.setBody("updadddd");
        dto.setUserId(24);

        Optional<Post> result =  postService.updatePost(dto);
        assertTrue(result.isPresent());
    }

    @Test
    public void findAllPost(){
        List<Post> result =  postService.finaAllPost();
        assertTrue(result.size() > 0);
    }
}
