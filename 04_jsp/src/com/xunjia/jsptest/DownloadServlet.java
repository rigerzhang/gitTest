package com.xunjia.jsptest;

import org.apache.commons.io.IOUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.util.Base64;

public class DownloadServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //1、获取下载的文件名
        String fileName = "1.jpg";
        //2、读取要下载的文件内容
        //2-1把文件变成流
        ServletContext servletContext = getServletContext();
        InputStream resourceAsStream = servletContext.getResourceAsStream("/img/" + fileName);
        //2-2获取要下载的文件类型
        String mimeType = servletContext.getMimeType("/img/" + fileName);
        //3、把下载的内容回传给客户端

        //4、在回传前告诉客户端返回的数据类型
        resp.setContentType(mimeType);
        //5、还要告诉客户端返回的数据是用于下载（通过响应头告诉）
        if (req.getHeader("User-Agent").contains("Firefox")) {
            //如果是火狐浏览器
            String str = "=?utf-8?B?" + Base64.getEncoder().encodeToString("中文.jpg".getBytes("utf-8")) + "?=";
            resp.setHeader("Content-Disposition", "attachment; fileName=" + str);

        } else {
            String str = URLEncoder.encode("中文.jpg", "UTF-8");
            resp.setHeader("Content-Disposition", "attachment; fileName=" + str);
        }

        //2-3获取响应流,并把文件流赋给他
        ServletOutputStream outputStream = resp.getOutputStream();
        IOUtils.copy(resourceAsStream, outputStream);

    }
}
