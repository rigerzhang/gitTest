package com.xunjia.service;

import com.xunjia.pojo.Book;
import com.xunjia.pojo.Page;

import java.util.List;

public interface BookService {
    public void addBook(Book book);
    public void deleteBookById(Integer id);
    public void updateBook(Book book);
    public Book queryBookById(Integer id);
    public List<Book> queryBooks();

    Page<Book> page(int pageNO, int pageSize);

    Page<Book> pageByPrice(int pageNO, int pageSize, int min, int max);
}
