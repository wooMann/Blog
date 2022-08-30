package com.blog.controller.post;

import com.blog.controller.Controller;
import com.blog.entity.Post;
import com.blog.service.PostService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

public class EditPostController implements Controller {
    @Override
    public String httpMethod() {
        return "GET";
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PostService postService = new PostService();
        Integer postId = Integer.valueOf(request.getParameter("id"));
        Optional<Post> result =  postService.findById(postId);

        if(result.isPresent()){
            request.setAttribute("post",result.get());
        }else {

        }

        return null;
    }
}
