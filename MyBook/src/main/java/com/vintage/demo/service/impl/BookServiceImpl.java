package com.vintage.demo.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.vintage.demo.mapper.BookMapper;
import com.vintage.demo.po.Book;
import com.vintage.demo.po.PageBean;
import com.vintage.demo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BookServiceImpl implements BookService {
    @Autowired
    private BookMapper bookMapper;

    @Override
    public List<Book> getAllBooks() {
        return this.bookMapper.getAllBooks();
    }

    @Override
    public List<Book> getSearchBooks(String sname) {
        return this.bookMapper.getSearchBooks(sname);
    }

    @Override
    public void deleteBook(Integer id) {
        this.bookMapper.deleteBook(id);
    }

    @Override
    public void updateBook(Book book) {
        this.bookMapper.updateBook(book);
    }

    @Override
    public void addBook(Book book) {
        this.bookMapper.addBook(book);
    }

    @Override
    public Book getBook(Integer id) {
        return this.bookMapper.getBook(id);
    }

    @Override
    public PageBean findByPage(Integer pageCode, Integer pageSize, String sname) {
        PageHelper.startPage(pageCode,pageSize);

        //调用分页查询方法，其实就是查询所有数据，mybatis自动帮我们进行分页计算
        Page<Book> page = (Page<Book>) bookMapper.getSearchBooks(sname);

        return new PageBean(page.getTotal(),page.getResult());
    }
}
