package com.vintage.demo.mapper;

import com.vintage.demo.po.Book;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface BookMapper {
    @Select("select * from b_book")
    List<Book> getAllBooks();

    @Delete("delete from b_book where id=#{id}")
    void deleteBook(Integer id);

    @Select("select * from b_book where bname like CONCAT('%',#{sname},'%')")
    List<Book> getSearchBooks(String sname);

    @Update("update b_book set categoryId=#{book.categoryId},bname=#{book.bname},cname=#{book.cname},picture=#{book.picture} where id=#{book.id}")
    void updateBook(@Param("book") Book book);

    @Insert("insert into b_book (categoryId,bname,cname,picture) values (#{book.categoryId},#{book.bname},#{book.cname},#{book.picture})")
    void addBook(@Param("book") Book book);

    @Select("select * from b_book where id=#{id}")
    Book getBook(Integer id);
}
