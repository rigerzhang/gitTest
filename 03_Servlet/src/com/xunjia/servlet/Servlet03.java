package com.xunjia.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

public class Servlet03 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        System.out.println("uri="+request.getRequestURI());
//        System.out.println("uri="+request.getRequestURL());
//        System.out.println("uri="+request.getRemoteHost());
//        System.out.println("uri="+request.getHeader("User-Agent"));
        request.setCharacterEncoding("utf-8");//调用参数获取之前用
        System.out.println("name="+request.getParameter("usr"));
        System.out.println("pwd="+request.getParameter("pwd"));
        String[] aihao=request.getParameterValues("aihao");
        System.out.println("aihao="+ Arrays.asList(aihao));
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        System.out.println("uri="+request.getRequestURI());
//        System.out.println("uri="+request.getRequestURL());
//        System.out.println("uri="+request.getRemoteHost());
//        System.out.println("uri="+request.getHeader("User-Agent"));
//        System.out.println("name="+request.getParameter("usr"));
//        System.out.println("pwd="+request.getParameter("pwd"));
//        String[] aihao=request.getParameterValues("aihao");
//        System.out.println("aihao="+ Arrays.asList(aihao));

        response.setCharacterEncoding("UTF-8");
        response.setHeader("content-type","text/html;charset=UTF-8");//获取流前面设置，否则无效
        PrintWriter writer = response.getWriter();
        writer.write("这是返回！");
    }
}
