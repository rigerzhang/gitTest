package com.xunjia.web;

import com.xunjia.pojo.Book;
import com.xunjia.pojo.Page;
import com.xunjia.service.BookService;
import com.xunjia.service.impl.BookServiceimpl;
import com.xunjia.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ClientBookServlet extends BaseServlet{
    BookService bookService=new BookServiceimpl();
    protected void page(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int pageNO = WebUtils.parseInt(req.getParameter("pageNO"), 1);
        int pageSize = WebUtils.parseInt(req.getParameter("pageSize"), Page.PAGE_SIZE);
        String url="client/bookServlet?action=page";
        Page<Book> page = bookService.page(pageNO, pageSize);

        page.setUrl(url);
        req.setAttribute("page", page);
        //需要重定向，不能请求转发
        req.getRequestDispatcher("/pages/client/index.jsp").forward(req, resp);

    }
    protected void pageByPrice(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int pageNO = WebUtils.parseInt(req.getParameter("pageNO"), 1);
        int pageSize = WebUtils.parseInt(req.getParameter("pageSize"), Page.PAGE_SIZE);
        int min=WebUtils.parseInt(req.getParameter("min"),0);
        int max=WebUtils.parseInt(req.getParameter("max"),Integer.MAX_VALUE);

        String url="client/bookServlet?action=pageByPrice";
        if(req.getParameter("min")!=null){
            url=url+"&min="+req.getParameter("min");
        }
        if(req.getParameter("max")!=null){
            url=url+"&max="+req.getParameter("max");
        }
        Page<Book> page = bookService.pageByPrice(pageNO, pageSize,min,max);

        page.setUrl(url);
        req.setAttribute("page", page);
        //需要重定向，不能请求转发
        req.getRequestDispatcher("/pages/client/index.jsp").forward(req, resp);

    }
}
