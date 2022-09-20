package com.blog.controller;

import com.blog.router.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

@WebServlet("*.do")
public class FrontController extends HttpServlet {
    private HashMap<String,Controller> controllerMap = new HashMap<>();

    @Override
    public void init() throws ServletException {
        new MainRoute(controllerMap);
        new EmailTokensRoute(controllerMap);
        new PostRoute(controllerMap);
        new UserRoute(controllerMap);
        new CommentRoute(controllerMap);
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = req.getRequestURI();
        String contextPath = req.getContextPath();
        String path = url.substring(contextPath.length());

        if(controllerMap.containsKey(path)){
            Controller frontController = controllerMap.get(path);
            String method = req.getMethod();

            if(method.equals(frontController.httpMethod())){
                String viewPath = frontController.execute(req, resp);
                req.getRequestDispatcher(viewPath).forward(req,resp);
            }else {
                System.out.println("잘못된 요청입니다");
            }
        }else {
            System.out.println("찾을수 없는 페이지 입니다.");
        }
    }

    @Override
    public void destroy() {
        super.destroy();
    }


}
