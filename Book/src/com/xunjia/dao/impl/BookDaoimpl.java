package com.xunjia.dao.impl;

import com.xunjia.dao.BookDao;
import com.xunjia.pojo.Book;

import java.util.List;

public class BookDaoimpl extends BaseAdo implements BookDao {
    @Override
    public int addBook(Book book) {
        String sql = "insert t_book(name,author,price,sales,stock,img_path)values(?,?,?,?,?,?)";
        return update(sql, book.getName(), book.getAuthor(), book.getPrice(), book.getSales(), book.getStock()
                , book.getImg_path());

    }

    @Override
    public int deleteBookById(Integer id) {
        String sql = "delete from t_book where id=?";
        return update(sql, id);
    }


    @Override
    public int updateBook(Book book) {
        String sql = "update t_book set name=?,author=?,price=?,sales=?,stock=?,img_path=? where id=?";
        return update(sql, book.getName(), book.getAuthor(), book.getPrice(), book.getSales(), book.getStock()
                , book.getImg_path(), book.getId());
    }

    @Override
    public Book queryBookById(Integer id) {
        String sql = "select * from t_book where id=?";
        return queryForOne(Book.class, sql, id);
    }

    @Override
    public List<Book> queryBooks() {
        String sql = "select * from t_book";
        return queryForList(Book.class, sql);
    }

    @Override
    public List<Book> queryForPageItems(int begin, int pageSize) {
        String sql = "select * from t_book limit ?,?";
        return queryForList(Book.class, sql,begin,pageSize);
    }

    @Override
    public int queryForPageTotalCount() {
        String sql = "select count(*) from t_book";
        Number number=(Number) queryForSingleValue(sql);

        return number.intValue();

    }

    @Override
    public int queryForPageTotalCountByPrice(int min, int max) {
        String sql = "select count(*) from t_book where price between ? and ?";
        Number number=(Number) queryForSingleValue(sql,min,max);

        return number.intValue();
    }

    @Override
    public List<Book> queryForPageItemsByPrice(int begin, int pageSize, int min, int max) {
        String sql = "select * from t_book where price between ? and ? order by price limit ?,?";
        return queryForList(Book.class, sql,min,max,begin,pageSize);
    }
}
