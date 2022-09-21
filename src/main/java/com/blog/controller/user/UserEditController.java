package com.blog.controller.user;

import com.blog.controller.Controller;
import com.blog.data.dto.user.UserDTO;
import com.blog.data.entity.User;
import com.blog.manager.ResponseManager;
import com.blog.manager.SessionManager;
import com.blog.mapper.UserMapper;
import com.blog.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Optional;

public class UserEditController implements Controller {

    @Override
    public String doGet(HttpServletRequest request, HttpServletResponse response) {
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

    @Override
    public String doPost(HttpServletRequest request, HttpServletResponse response) {
        UserService userService = new UserService();
        UserDTO dto = UserMapper.mapping(request);

        if(dto.getPassword().equals("")) dto.setPassword(
                userService.findById(dto.getId()).get().getPassword()
        );

        Optional<User> result =  userService.updateUser(dto);
        if (result.isPresent()){
            ResponseManager.responsePath(request,"/main.do");
        }else {
            ResponseManager.responseFailWithMessage(request,"사용자 수정에 실패했습니다");
        }
        return "/blog/pathHandler.jsp";
    }


}
