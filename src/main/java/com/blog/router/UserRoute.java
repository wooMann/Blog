package com.blog.router;

import com.blog.controller.Controller;
import com.blog.controller.user.UserEditController;
import com.blog.controller.user.UserListController;

import java.util.HashMap;

public class UserRoute {
    public UserRoute(HashMap<String, Controller> map) {
        map.put("/user/list.do",new UserListController());
        map.put("/user/edit.do",new UserEditController());
    }
}
