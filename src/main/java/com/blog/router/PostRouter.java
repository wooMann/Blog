package com.blog.router;

import com.blog.controller.Controller;
import com.blog.controller.post.*;

import java.util.HashMap;

public class PostRouter {
    public PostRouter(HashMap<String, Controller> map){
        map.put("/post/list.do",new PostListController());
        map.put("/post/create.do",new CreatePostController());
        map.put("/post/createProc.do",new CreateProcPostController());
        map.put("/post/edit.do",new EditPostController());
        map.put("/post/editProc.do",new EditProcPostController());
    }
}
