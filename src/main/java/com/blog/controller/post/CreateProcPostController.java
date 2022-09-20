package com.blog.controller.post;

import com.blog.controller.Controller;
import com.blog.data.dto.post.PostDTO;
import com.blog.data.entity.Post;
import com.blog.manager.SessionManager;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class CreateProcPostController implements Controller {
    @Override
    public String httpMethod() {
        return "POST";
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

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
