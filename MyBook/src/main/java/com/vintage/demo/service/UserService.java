package com.vintage.demo.service;

import com.vintage.demo.po.PageBean;
import com.vintage.demo.po.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    List<User> getSearchUsers(String sname);
    void deleteUser(Integer id);
    void updateUser(User user);
    void addUser(User user);
    User getUser(Integer id);
    PageBean findByPage(Integer pageCode, Integer pageSize, String sname);
}
