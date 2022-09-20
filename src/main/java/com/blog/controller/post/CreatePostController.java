package com.blog.controller.post;

import com.blog.controller.Controller;
import com.blog.data.entity.Post;
import com.blog.manager.ResponseManager;
import com.blog.service.PostService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

public class CreatePostController implements Controller {
    @Override
    public String doGet(HttpServletRequest request, HttpServletResponse response) {
        return "/blog/post/postInputForm.jsp";
    }

    @Override
    public String doPost(HttpServletRequest request, HttpServletResponse response) {
        PostService postService = new PostService();
        Optional<Post> result =  postService.createPost(makeDTO(request));
        if (result.isPresent()){
            ResponseManager.responsePath(request,"/post/list.do");
        }else {
            ResponseManager.responseFailWithMessage(request,"글 등록에 실패했습니다");
        }
        return "/blog/pathHandler.jsp";
    }




}
