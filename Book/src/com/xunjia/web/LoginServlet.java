package com.xunjia.web;

import com.xunjia.pojo.User;
import com.xunjia.service.UserService;
import com.xunjia.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserService userService=new UserServiceImpl();
        String username = req.getParameter("username");
        String pwd=req.getParameter("password");
        User loginUser=userService.login(new User(null,username,pwd,null));

        if(loginUser!=null){
            System.out.println("登入成功!");
            req.getSession().setAttribute("loginUser",loginUser);
            req.getRequestDispatcher("pages/user/login_success.jsp").forward(req,resp);
        }else {
            System.out.println("登入失败！");
            req.setAttribute("msg","用户名或密码错误");
            req.setAttribute("username",username);
            req.getRequestDispatcher("pages/user/login.jsp").forward(req,resp);

        }
    }
}
