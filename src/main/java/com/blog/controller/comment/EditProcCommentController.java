package com.blog.controller.comment;

import com.blog.controller.Controller;
import com.blog.data.dto.comment.CommentDTO;
import com.blog.manager.SessionManager;
import com.blog.mapper.CommentMapper;
import com.blog.service.CommentService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class EditProcCommentController implements Controller {
    @Override
    public String doGet(HttpServletRequest request, HttpServletResponse response) {
        return null;
    }

    @Override
    public String doPost(HttpServletRequest request, HttpServletResponse response) {
        CommentService commentService = new CommentService();
        commentService.updateComment(CommentMapper.mapping(request));

        return "";
    }

    private CommentDTO makeDTO(HttpServletRequest request){
        HttpSession session = request.getSession();
        CommentDTO dto = new CommentDTO();
        dto.setPostId(Integer.valueOf(request.getParameter("post_id")));
        dto.setUserId((Integer) session.getAttribute(SessionManager.SESSION_ID));
        dto.setUserIp(request.getParameter("user_ip"));
        dto.setBody(request.getParameter("comment_body"));
        dto.setCommentId(Integer.valueOf(request.getParameter("comment_id")));

        return dto;
    }
}
