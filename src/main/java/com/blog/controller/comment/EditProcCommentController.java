package com.blog.controller.comment;

import com.blog.controller.Controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class EditProcCommentController implements Controller {
    private String METHOD = "POST";

    @Override
    public String httpMethod() {
        return METHOD;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        return null;
    }
}
