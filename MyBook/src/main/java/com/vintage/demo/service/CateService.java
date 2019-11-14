package com.vintage.demo.service;

import com.vintage.demo.po.PageBean;
import com.vintage.demo.po.Cate;

import java.util.List;

public interface CateService {
    List<Cate> getAllCates();
    List<Cate> getSearchCates(String sname);
    void deleteCate(Integer id);
    void updateCate(Cate cate);
    void addCate(Cate cate);
    Cate getCate(Integer id);
    PageBean findByPage(Integer pageCode, Integer pageSize, String sname);
    String getCateById(Integer id);
}
