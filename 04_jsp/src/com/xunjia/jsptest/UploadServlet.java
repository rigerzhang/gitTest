package com.xunjia.jsptest;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UploadServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletInputStream inputStream = req.getInputStream();
        byte[] buff=new byte[102400000];
        int readlengh = inputStream.read(buff);
        System.out.println(new String(buff,0,readlengh));
        System.out.println("End");

//        if (ServletFileUpload.isMultipartContent(req)){
//            FileItemFactory fileItemFactory=new DiskFileItemFactory();
//            ServletFileUpload servletFileUpload = new ServletFileUpload(fileItemFactory);
//
//            try {
//                List<FileItem> list = servletFileUpload.parseRequest(req);
//
//                Iterator<FileItem> itemIterator=list.iterator();
//                while (itemIterator.hasNext()){
//                    FileItem item=itemIterator.next();
//                    if (item.isFormField()){
//                        System.out.println(item.getFieldName());
//                        System.out.println(item.getString("utf-8"));
//                    }
//                    else {
//                        System.out.println(item.getName());
//                        //item.write(new File("/Users/zhangli/Pictures/"+item.getName()));
//                    }
//                }
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }else {
//
//        }

    }
}
