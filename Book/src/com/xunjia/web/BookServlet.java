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
import java.util.List;

public class BookServlet extends BaseServlet {
    private BookService bookService = new BookServiceimpl();

    protected void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Book> books = bookService.queryBooks();
        req.setAttribute("books", books);
        req.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(req, resp);
    }

    protected void page(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int pageNO = WebUtils.parseInt(req.getParameter("pageNO"), 1);
        int pageSize = WebUtils.parseInt(req.getParameter("pageSize"), Page.PAGE_SIZE);
        String url="manager/bookServlet?action=page";

        Page<Book> page = bookService.page(pageNO, pageSize);

        page.setUrl(url);
        req.setAttribute("page", page);
        //需要重定向，不能请求转发
        req.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(req, resp);

    }

    protected void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Book book = WebUtils.copyPramaToBean(req.getParameterMap(), new Book());

        int pageNO = WebUtils.parseInt(req.getParameter("pageNO"), 0);
        int pageTotalCount=WebUtils.parseInt(req.getParameter("pageTotalCount"),0);

        if(pageTotalCount%Page.PAGE_SIZE==0)
            pageNO+=1;

        bookService.addBook(book);

        //需要重定向，不能请求转发
        //req.getRequestDispatcher("manager/bookServlet?action=list").forward(req,resp);

        resp.sendRedirect(req.getContextPath() + "/manager/bookServlet?action=page&pageNO=" + pageNO);
    }

    protected void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = WebUtils.parseInt(req.getParameter("id"), 0);
        int pageNO = WebUtils.parseInt(req.getParameter("pageNO"), 0);

        bookService.deleteBookById(id);

        //需要重定向，不能请求转发
        //req.getRequestDispatcher("manager/bookServlet?action=list").forward(req,resp);

        resp.sendRedirect(req.getContextPath() + "/manager/bookServlet?action=page&pageNO="+pageNO);
    }

    protected void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Book book = WebUtils.copyPramaToBean(req.getParameterMap(), new Book());
        bookService.updateBook(book);
        int pageNO = WebUtils.parseInt(req.getParameter("pageNO"), 0);

        //需要重定向，不能请求转发
        //req.getRequestDispatcher("manager/bookServlet?action=list").forward(req,resp);

        resp.sendRedirect(req.getContextPath() + "/manager/bookServlet?action=page&pageNO="+pageNO);
    }

    protected void getBook(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = WebUtils.parseInt(req.getParameter("id"), 0);

        Book book = bookService.queryBookById(id);

        req.setAttribute("book", book);
        //需要请求转发
        req.getRequestDispatcher("/pages/manager/book_edit.jsp").forward(req, resp);

//        resp.sendRedirect(req.getContextPath()+"/manager/bookServlet?action=list");
    }
}
