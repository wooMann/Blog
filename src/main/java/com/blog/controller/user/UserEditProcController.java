package com.blog.controller.user;

import com.blog.controller.Controller;
import com.blog.dto.user.UserDTO;
import com.blog.entity.User;
import com.blog.manager.ResponseManager;
import com.blog.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

public class UserEditProcController implements Controller {
    @Override
    public String httpMethod() {
        return "POST";
    }

    private UserDTO makeDTO(HttpServletRequest request ){
        UserDTO dto = new UserDTO();
        dto.setId(Integer.valueOf(request.getParameter("id")));
        dto.setEmail(request.getParameter("email"));
        dto.setPassword(request.getParameter("password"));
        dto.setName(request.getParameter("name"));
        return dto;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserService userService = new UserService();
        UserDTO dto = makeDTO(request);

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
