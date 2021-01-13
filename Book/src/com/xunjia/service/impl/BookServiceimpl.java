package com.xunjia.service.impl;

import com.xunjia.dao.BookDao;
import com.xunjia.dao.impl.BookDaoimpl;
import com.xunjia.pojo.Book;
import com.xunjia.pojo.Page;
import com.xunjia.service.BookService;

import java.util.List;

public class BookServiceimpl implements BookService {
    private BookDao bookDao = new BookDaoimpl();

    @Override
    public void addBook(Book book) {
        bookDao.addBook(book);
    }

    @Override
    public void deleteBookById(Integer id) {
        bookDao.deleteBookById(id);

    }

    @Override
    public void updateBook(Book book) {
        bookDao.updateBook(book);

    }

    @Override
    public Book queryBookById(Integer id) {
        return bookDao.queryBookById(id);
    }

    @Override
    public List<Book> queryBooks() {
        return bookDao.queryBooks();
    }

    @Override
    public Page<Book> page(int pageNO, int pageSize) {
        Page<Book> page = new Page<Book>();
        page.setPageSize(pageSize);

        int pageTotalCount = bookDao.queryForPageTotalCount();
        page.setPageTotalCount(pageTotalCount);
        Integer pageTotal = pageTotalCount / pageSize;
        if (pageTotalCount % pageSize > 0) {
            pageTotal += 1;
        }
        page.setPageTotal(pageTotal);

        if (pageNO < 1) {
            pageNO = 1;
        } else if (pageNO > pageTotal) {
            pageNO = pageTotal;
        }
        page.setPageNO(pageNO);

        //////--------------////////////
        int begin = (pageNO - 1) * pageSize;
        List<Book> items = bookDao.queryForPageItems(begin, pageSize);

        page.setItems(items);

        return page;
    }

    @Override
    public Page<Book> pageByPrice(int pageNO, int pageSize, int min, int max) {
        Page<Book> page = new Page<Book>();
        page.setPageSize(pageSize);

        int pageTotalCount = bookDao.queryForPageTotalCountByPrice(min,max);
        page.setPageTotalCount(pageTotalCount);
        Integer pageTotal = pageTotalCount / pageSize;
        if (pageTotalCount % pageSize > 0) {
            pageTotal += 1;
        }
        page.setPageTotal(pageTotal);

        if (pageNO < 1) {
            pageNO = 1;
        } else if (pageNO > pageTotal) {
            pageNO = pageTotal;
        }
        page.setPageNO(pageNO);

        //////--------------////////////
        int begin = (pageNO - 1) * pageSize;
        List<Book> items = bookDao.queryForPageItemsByPrice(begin, pageSize,min,max);

        page.setItems(items);

        return page;
    }
}
