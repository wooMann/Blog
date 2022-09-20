package com.blog.router;

import com.blog.controller.Controller;
import com.blog.controller.comment.CreateProcCommentController;
import com.blog.controller.user.UserListController;

import java.util.HashMap;

public class CommentRoute {
    public CommentRoute(HashMap<String, Controller> map) {

        map.put("/comment/createProc.do",new CreateProcCommentController());
    }
}

