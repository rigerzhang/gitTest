package com.xunjia.web;

import com.xunjia.pojo.User;
import com.xunjia.service.UserService;
import com.xunjia.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegistServlet extends HttpServlet {
    public RegistServlet() {
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        UserService userService=new UserServiceImpl();

        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String code = req.getParameter("code");
        if ("abcd".equalsIgnoreCase(code)){    //验证码正确
            if (userService.register(new User(null,username,password,email))) {
                req.getRequestDispatcher("pages/user/regist_success.jsp").forward(req, resp);
                System.out.println("注册成功");
            }
            else {
                System.out.println("注册失败");
                req.setAttribute("msg","注册失败");
                req.getRequestDispatcher("pages/user/regist.jsp").forward(req,resp);
            }
        }else {//不正确跳转原画面
            System.out.println("注册码不是abcd");
            req.setAttribute("msg","验证码错误");
            req.getRequestDispatcher("pages/user/regist.jsp").forward(req,resp);
        }
    }
}
