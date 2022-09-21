package com.blog.router;

import com.blog.controller.Controller;
import com.blog.controller.comment.CreateCommentController;

import java.util.HashMap;

public class CommentRoute {
    public CommentRoute(HashMap<String, Controller> map) {

        map.put("/comment/createProc.do",new CreateCommentController());
    }
}

