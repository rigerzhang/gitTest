package com.xunjia.web;

import com.xunjia.pojo.User;
import com.xunjia.service.UserService;
import com.xunjia.service.impl.UserServiceImpl;
import com.xunjia.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY;

public class UserServlet extends BaseServlet {

    private UserService userService = new UserServiceImpl();

    protected void loginOut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().invalidate();

        resp.sendRedirect(req.getContextPath());
    }
    protected void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user=WebUtils.copyPramaToBean(req.getParameterMap(),new User());
        if (userService.login(user) != null) {
            System.out.println("登入成功!");
            req.getSession().setAttribute("loginUser",userService.login(user));
            req.getRequestDispatcher("pages/user/login_success.jsp").forward(req, resp);
        } else {
            System.out.println("登入失败！");
            req.setAttribute("msg", "用户名或密码错误");
            req.getRequestDispatcher("pages/user/login.jsp").forward(req, resp);
        }
    }

    protected void regist(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String code = req.getParameter("code");
        User user=WebUtils.copyPramaToBean(req.getParameterMap(),new User());

        String takon = (String) req.getSession().getAttribute(KAPTCHA_SESSION_KEY);
        req.getSession().removeAttribute(KAPTCHA_SESSION_KEY);

        if (takon!=null && takon.equalsIgnoreCase(code)) {    //验证码正确
            if (userService.register(user)) {
                req.getRequestDispatcher("pages/user/regist_success.jsp").forward(req, resp);
                System.out.println("注册成功");
            } else {
                req.setAttribute("msg", "注册失败");
                req.getRequestDispatcher("pages/user/regist.jsp").forward(req, resp);
                System.out.println("注册失败");
            }
        } else {//不正确跳转原画面
            System.out.println("注册码错误");
            req.setAttribute("msg", "验证码错误");
            req.getRequestDispatcher("pages/user/regist.jsp").forward(req, resp);
        }
    }
}
