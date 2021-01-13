package com.xunjia.web;

import com.xunjia.pojo.Book;
import com.xunjia.pojo.Cart;
import com.xunjia.pojo.CartItem;
import com.xunjia.service.BookService;
import com.xunjia.service.impl.BookServiceimpl;
import com.xunjia.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CartServlet extends BaseServlet {

    BookService bookService = new BookServiceimpl();

    protected void clear(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        cart.clear();
        //resp.sendRedirect(req.getContextPath());
        resp.sendRedirect(req.getContextPath() + "/pages/cart/cart.jsp");

    }

    protected void deleteItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = WebUtils.parseInt(req.getParameter("id"), 0);
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        cart.deleteItem(id);
        //resp.sendRedirect(req.getContextPath());
        resp.sendRedirect(req.getContextPath() + "/pages/cart/cart.jsp");

    }

    protected void addItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = WebUtils.parseInt(req.getParameter("id"), 0);
        Book book = bookService.queryBookById(id);
        if (book != null) {
            CartItem cartItem = new CartItem(book.getId(), book.getName(), 1, book.getPrice(), book.getPrice());
            Cart cart = (Cart) req.getSession().getAttribute("cart");
            if (cart == null) {
                cart = new Cart();
                req.getSession().setAttribute("cart", cart);

            }
            cart.addItem(cartItem);
            //resp.sendRedirect(req.getContextPath());
            resp.sendRedirect(req.getHeader("Referer"));

        }
    }
}
