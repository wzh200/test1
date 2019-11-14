package com.vintage.demo.service;

import com.vintage.demo.po.PageBean;
import com.vintage.demo.po.Book;

import java.util.List;

public interface BookService {
    List<Book> getAllBooks();
    List<Book> getSearchBooks(String sname);
    void deleteBook(Integer id);
    void updateBook(Book book);
    void addBook(Book book);
    Book getBook(Integer id);
    PageBean findByPage(Integer pageCode, Integer pageSize, String sname);
}
