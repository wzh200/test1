package com.vintage.demo.controller;

import com.vintage.demo.po.PageBean;
import com.vintage.demo.po.Cate;
import com.vintage.demo.service.CateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/cate")
public class CateController {
    @Autowired
    private CateService cateService;

    @RequestMapping("/findByPage")
    public PageBean findByPage(@RequestBody Map<String, List> map) {
        return this.cateService.findByPage((Integer) map.get("params").get(0),(Integer) map.get("params").get(1),(String) map.get("params").get(2));

    }

    @RequestMapping("/cateGet")
    public Cate cateGet(@RequestBody Map<String,Cate> map){
        Cate cate = this.cateService.getCate(map.get("cate").getId());
        return cate;
    }

    @RequestMapping("/cateList")
    public List<Cate> getAllCates(){
        List<Cate> list = this.cateService.getAllCates();
        return list;
    }

    @RequestMapping("/cateUpdate")
    public void cateUpdate(@RequestBody Map<String,Cate> map){
        Cate cate = map.get("cate");
        this.cateService.updateCate(cate);
    }

    @RequestMapping("/cateAdd")
    public boolean cateAdd(@RequestBody Map<String,Cate> map){
        boolean f = true;
        Cate cate = map.get("cate");
        this.cateService.addCate(cate);
        return f;
    }

    @RequestMapping("/cateSearch")
    public List<Cate> getSearchCates(@RequestBody Map<String,String> map){
        List<Cate> list = this.cateService.getSearchCates(map.get("sname"));
        return list;
    }

    @RequestMapping("/cateDelete")
    public void deleteCate(@RequestBody Map<String,Integer> map){
        this.cateService.deleteCate(map.get("id"));
    }
}
