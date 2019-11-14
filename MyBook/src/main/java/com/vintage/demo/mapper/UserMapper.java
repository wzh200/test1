package com.vintage.demo.mapper;

import com.vintage.demo.po.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {
    @Select("select * from b_admin")
    List<User> getAllUsers();

    @Delete("delete from b_admin where id=#{id}")
    void deleteUser(Integer id);

    @Select("select * from b_admin where name like CONCAT('%',#{sname},'%')")
    List<User> getSearchUsers(String sname);

    @Update("update b_admin set name=#{user.name},sex=#{user.sex},email=#{user.email},pass=#{user.pass} where id=#{user.id}")
    void updateUser(@Param("user") User user);

    @Insert("insert into b_admin (name,sex,pass,email) values (#{user.name},#{user.sex},#{user.pass},#{user.email})")
    void addUser(@Param("user") User user);

    @Select("select * from b_admin where id=#{id}")
    User getUser(Integer id);
}
