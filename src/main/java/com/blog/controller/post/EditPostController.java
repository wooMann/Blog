package com.blog.controller.post;

import com.blog.controller.Controller;
import com.blog.data.entity.Post;
import com.blog.manager.ResponseManager;
import com.blog.mapper.PostMapper;
import com.blog.service.PostService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

public class EditPostController implements Controller {

    @Override
    public String doGet(HttpServletRequest request, HttpServletResponse response) {
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
            ResponseManager.responseFailWithMessageAndPath(request,"존재하지 않는 게시물입니다","/post/list.do");
            return "/blog/pathHandler.jsp";
        }
    }

    @Override
    public String doPost(HttpServletRequest request, HttpServletResponse response) {
        PostService postService = new PostService();
        Optional<Post> result = postService.updatePost(PostMapper.mapping(request));
        if (result.isPresent()){
            ResponseManager.responsePath(request,"/post/edit.do?id="+result.get().getId());
        }else {
            ResponseManager.responseFailWithMessage(request,"글 수정에 실패 했습니다.");
        }
        return "/blog/pathHandler.jsp";
    }



}
