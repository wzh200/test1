package com.vintage.demo.mapper;

import com.vintage.demo.po.Cate;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CateMapper {
    @Select("select category from b_category where id=#{categoryId}")
    String getCateById(Integer id);

    @Select("select * from b_category")
    List<Cate> getAllCates();

    @Delete("delete from b_category where id=#{id}")
    void deleteCate(Integer id);

    @Select("select * from b_category where category like CONCAT('%',#{sname},'%')")
    List<Cate> getSearchCates(String sname);

    @Update("update b_category set category=#{cate.category} where id=#{cate.id}")
    void updateCate(@Param("cate") Cate cate);

    @Insert("insert into b_category (category) values (#{cate.category})")
    void addCate(@Param("cate") Cate cate);

    @Select("select * from b_category where id=#{id}")
    Cate getCate(Integer id);
}
