package com.blog.controller.comment;

import com.blog.controller.Controller;
import com.blog.data.entity.Comment;
import com.blog.manager.ResponseManager;
import com.blog.mapper.CommentMapper;
import com.blog.service.CommentService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

public class CreateCommentController implements Controller {
    @Override
    public String doGet(HttpServletRequest request, HttpServletResponse response) {
        return null;
    }

    @Override
    public String doPost(HttpServletRequest request, HttpServletResponse response) {
        CommentService commentService = new CommentService();
        Optional<Comment> result = commentService.createComment(CommentMapper.mapping(request));
        if(result.isPresent()){
            ResponseManager.responsePath(request,"/post/edit.do?id="+result.get().getPost().getId());
        }else {
            ResponseManager.responseFailWithMessageAndPath(request,"댓글 등록 실패","/post/edit.do?id="+result.get().getPost().getId());
        }
        return "/blog/pathHandler.jsp";
    }


}
