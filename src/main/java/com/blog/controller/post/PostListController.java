package com.blog.controller.post;

import com.blog.controller.Controller;
import com.blog.data.entity.Post;
import com.blog.service.PostService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class PostListController implements Controller {

    @Override
    public String doGet(HttpServletRequest request, HttpServletResponse response) {
        PostService postService = new PostService();
        List<Post> postList =  postService.finaAllPost();
        request.setAttribute("postList",postList);
        return "/blog/post/postsList.jsp";
    }

    @Override
    public String doPost(HttpServletRequest request, HttpServletResponse response) {
        return null;
    }
}
