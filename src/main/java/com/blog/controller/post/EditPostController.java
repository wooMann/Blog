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

        String ip = request.getHeader("X-Forwarded-For");
        if (ip == null) ip = request.getRemoteAddr();

        if(result.isPresent()){
            request.setAttribute("post",result.get());
            request.setAttribute("user_ip",ip);
            return "/blog/post/postInputForm.jsp";
        }else {
            request.setAttribute("message","존재하지 않는 게시물입니다");
            request.setAttribute("path","/post/list.do");
            return "/blog/pathHandler.jsp";
        }
    }
}
