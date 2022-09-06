package com.blog.controller.post;

import com.blog.controller.Controller;
import com.blog.dto.post.PostDTO;
import com.blog.entity.Post;
import com.blog.manager.SessionManager;
import com.blog.service.PostService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Optional;

public class CreateProcPostController implements Controller {
    @Override
    public String httpMethod() {
        return "POST";
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PostService postService = new PostService();
        boolean result =  postService.createPost(makeDTO(request));
        if (result){
            request.setAttribute("path","/post/list.do");
        }else {
            request.setAttribute("message","글 등록에 실패 했습니다.");
            request.setAttribute("path","javascript:history.back()");
        }
        return "/blog/pathHandler.jsp";
    }

    private PostDTO makeDTO(HttpServletRequest request){
        HttpSession session = request.getSession();
        PostDTO postDTO = new PostDTO();

        postDTO.setUserId((Integer) session.getAttribute(SessionManager.SESSION_ID));
        postDTO.setTitle(request.getParameter("title"));
        postDTO.setBody(request.getParameter("body"));

        return postDTO;
    }
}
