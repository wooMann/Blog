package com.blog.mapper;

import com.blog.data.dto.comment.CommentDTO;

import javax.servlet.http.HttpServletRequest;

public class CommentMapper {
    public static CommentDTO mapping(HttpServletRequest request){
        CommentDTO commentDTO = new CommentDTO();
        if(!request.getParameter("user_id").isEmpty()) commentDTO.setUserId(Integer.valueOf(request.getParameter("user_id")));
        //if(!request.getParameter("comment_id").isEmpty()) commentDTO.setCommentId(Integer.valueOf(request.getParameter("comment_id")));
        else commentDTO.setUserIp(request.getParameter("user_ip"));
        commentDTO.setPostId(Integer.valueOf(request.getParameter("post_id")));
        commentDTO.setBody(request.getParameter("body"));
        return commentDTO;
    }
}
