package com.blog.mapper;

import com.blog.data.dto.post.PostDTO;
import com.blog.manager.SessionManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class PostMapper {
    public static PostDTO mapping(HttpServletRequest request){

        HttpSession session = request.getSession();
        PostDTO postDTO = new PostDTO();

        if(request.getParameter("id") != null) postDTO.setId(Integer.valueOf(request.getParameter("id")));
        postDTO.setUserId((Integer) session.getAttribute(SessionManager.SESSION_ID));
        postDTO.setTitle(request.getParameter("title"));
        postDTO.setBody(request.getParameter("body"));

        return postDTO;
    }
}
