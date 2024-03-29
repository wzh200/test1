package com.vintage.demo.controller;

import com.vintage.demo.po.Cate;
import com.vintage.demo.po.PageBean;
import com.vintage.demo.po.Book;
import com.vintage.demo.service.BookService;
import com.vintage.demo.service.CateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    private BookService bookService;

    @Autowired
    private CateService cateService;

    @RequestMapping("/upload")
    public String upload(@RequestParam("picture") MultipartFile picture, HttpServletRequest request) {
        //获取文件在服务器的储存位置
        String path = request.getSession().getServletContext().getRealPath("/upload");
        File filePath = new File(path);
        System.out.println("文件的保存路径：" + path);
        if (!filePath.exists() && !filePath.isDirectory()) {
            System.out.println("目录不存在，创建目录:" + filePath);
            filePath.mkdir();
        }

        //获取原始文件名称(包含格式)
        String originalFileName = picture.getOriginalFilename();
        System.out.println("原始文件名称：" + originalFileName);

        //获取文件类型，以最后一个`.`为标识
        String type = originalFileName.substring(originalFileName.lastIndexOf(".") + 1);
        System.out.println("文件类型：" + type);
        //获取文件名称（不包含格式）
        String name = originalFileName.substring(0, originalFileName.lastIndexOf("."));

        //设置文件新名称: 当前时间+文件名称（不包含格式）
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        String date = sdf.format(d);
        String fileName = date + name + "." + type;
        System.out.println("新文件名称：" + fileName);

        //在指定路径下创建一个文件
        File targetFile = new File(path, fileName);

        //将文件保存到服务器指定位置
        try {
            picture.transferTo(targetFile);
            System.out.println("上传成功");
            //将文件在服务器的存储路径返回
            return "/upload/" + fileName;
        } catch (IOException e) {
            System.out.println("上传失败");
            e.printStackTrace();
            return "上传失败";
        }
    }

    @RequestMapping("/getAllCate")
    public List<Cate> getAllCate(){
        return this.cateService.getAllCates();
    }

    @RequestMapping("/findByPage")
    public PageBean findByPage(@RequestBody Map<String, List> map) {
        return this.bookService.findByPage((Integer) map.get("params").get(0),(Integer) map.get("params").get(1),(String) map.get("params").get(2));

    }

    @RequestMapping("/bookGet")
    public Book bookGet(@RequestBody Map<String,Book> map){
        Book book = this.bookService.getBook(map.get("book").getId());
        return book;
    }

    @RequestMapping("/bookList")
    public List<Book> getAllBooks(){
        return this.bookService.getAllBooks();
    }

    @RequestMapping("/bookUpdate")
    public void bookUpdate(@RequestBody Map<String,Book> map){
        Book book = map.get("book");
        String cname = this.cateService.getCateById(map.get("book").getCategoryId());
        book.setCname(cname);
        this.bookService.updateBook(book);
    }

    @RequestMapping("/bookAdd")
    public boolean bookAdd(@RequestBody Map<String,Book> map){
        boolean f = true;
        Book book = map.get("book");
        String cname = this.cateService.getCateById(map.get("book").getCategoryId());
        book.setCname(cname);
        System.out.println(book);
        this.bookService.addBook(book);
        return f;
    }

    @RequestMapping("/bookSearch")
    public List<Book> getSearchBooks(@RequestBody Map<String,String> map){
        List<Book> list = this.bookService.getSearchBooks(map.get("sname"));
        return list;
    }

    @RequestMapping("/bookDelete")
    public void deleteBook(@RequestBody Map<String,Integer> map){
        this.bookService.deleteBook(map.get("id"));
    }
}
