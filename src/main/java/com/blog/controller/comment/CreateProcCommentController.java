package com.blog.controller.comment;

import com.blog.controller.Controller;
import com.blog.dto.comment.CommentDTO;
import com.blog.entity.Comment;
import com.blog.service.CommentService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

public class CreateProcCommentController implements Controller {
    @Override
    public String httpMethod() {
        return "POST";
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CommentService commentService = new CommentService();
        Optional<Comment> result = commentService.createComment(makeDTO(request));
        if(result.isPresent()){
            request.setAttribute("path","/post/edit.do?id="+result.get().getPost().getId());
        }else {
            request.setAttribute("message","댓글 등록 실패");
            request.setAttribute("path","/post/edit.do?id="+result.get().getPost().getId());
        }
        return "/blog/pathHandler.jsp";
    }

    private CommentDTO makeDTO(HttpServletRequest request){
        CommentDTO commentDTO = new CommentDTO();
        if(!request.getParameter("user_id").isEmpty()) commentDTO.setUserId(Integer.valueOf(request.getParameter("user_id")));
        else commentDTO.setUserIp(request.getParameter("user_ip"));


        commentDTO.setPostId(Integer.valueOf(request.getParameter("post_id")));

        commentDTO.setBody(request.getParameter("body"));

        return commentDTO;
    }
}
