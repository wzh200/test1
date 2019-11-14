package com.vintage.demo.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.vintage.demo.mapper.UserMapper;
import com.vintage.demo.po.PageBean;
import com.vintage.demo.po.User;
import com.vintage.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public PageBean findByPage(Integer pageCode, Integer pageSize, String sname) {
        //使用Mybatis分页插件
        PageHelper.startPage(pageCode,pageSize);

        //调用分页查询方法，其实就是查询所有数据，mybatis自动帮我们进行分页计算
        Page<User> page = (Page<User>) userMapper.getSearchUsers(sname);

        return new PageBean(page.getTotal(),page.getResult());
    }

    @Override
    public List<User> getAllUsers() {
        return this.userMapper.getAllUsers();
    }

    @Override
    public List<User> getSearchUsers(String sname){
        return this.userMapper.getSearchUsers(sname);
    }

    @Override
    public void deleteUser(Integer id) {
        this.userMapper.deleteUser(id);
    }

    @Override
    public void updateUser(User user) {
        this.userMapper.updateUser(user);
    }

    @Override
    public void addUser(User user) {
        this.userMapper.addUser(user);
    }

    @Override
    public User getUser(Integer id) {
        return this.userMapper.getUser(id);
    }
}
