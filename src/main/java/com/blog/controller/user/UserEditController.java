package com.blog.controller.user;

import com.blog.controller.Controller;
import com.blog.entity.User;
import com.blog.manager.ResponseManager;
import com.blog.manager.SessionManager;
import com.blog.service.UserService;

import javax.mail.Session;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Optional;

public class UserEditController implements Controller {
    @Override
    public String httpMethod() {
        return "GET";
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        UserService userService = new UserService();
        Optional<User> result = userService.findById((Integer) session.getAttribute(SessionManager.SESSION_ID));
        if(result.isPresent()){
            request.setAttribute("user",result.get());
            return "/blog/user/userInputForm.jsp";
        }else {
            ResponseManager.responseFailWithMessageAndPath(request,"찾을 수 없는 사용자 입니다.","/main.do");
            return "/blog/pathHandler.jsp";
        }
    }
}
