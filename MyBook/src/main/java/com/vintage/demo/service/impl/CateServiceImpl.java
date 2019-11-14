package com.vintage.demo.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.vintage.demo.mapper.CateMapper;
import com.vintage.demo.po.Cate;
import com.vintage.demo.po.PageBean;
import com.vintage.demo.service.CateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CateServiceImpl implements CateService {
    @Autowired
    private CateMapper cateMapper;

    @Override
    public List<Cate> getAllCates() {
        return this.cateMapper.getAllCates();
    }

    @Override
    public List<Cate> getSearchCates(String sname) {
        return this.cateMapper.getSearchCates(sname);
    }

    @Override
    public void deleteCate(Integer id) {
        this.cateMapper.deleteCate(id);
    }

    @Override
    public void updateCate(Cate cate) {
        this.cateMapper.updateCate(cate);
    }

    @Override
    public void addCate(Cate cate) {
        this.cateMapper.addCate(cate);
    }

    @Override
    public Cate getCate(Integer id) {
        return this.cateMapper.getCate(id);
    }

    @Override
    public PageBean findByPage(Integer pageCode, Integer pageSize, String sname) {
        PageHelper.startPage(pageCode,pageSize);

        //调用分页查询方法，其实就是查询所有数据，mybatis自动帮我们进行分页计算
        Page<Cate> page = (Page<Cate>) cateMapper.getSearchCates(sname);

        return new PageBean(page.getTotal(),page.getResult());
    }

    @Override
    public String getCateById(Integer id) {
        return this.cateMapper.getCateById(id);
    }
}
