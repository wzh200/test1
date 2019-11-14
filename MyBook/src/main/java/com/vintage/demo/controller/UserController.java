package com.vintage.demo.controller;

import com.vintage.demo.po.PageBean;
import com.vintage.demo.po.User;
import com.vintage.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/findByPage")
    public PageBean findByPage(@RequestBody Map<String,List> map) {
        return this.userService.findByPage((Integer) map.get("params").get(0),(Integer) map.get("params").get(1),(String) map.get("params").get(2));

    }

    @RequestMapping("/userGet")
    public User userGet(@RequestBody Map<String,User> map){
        User user = this.userService.getUser(map.get("user").getId());
        return user;
    }

    @RequestMapping("/userList")
    public List<User> getAllUsers(){
        List<User> list = this.userService.getAllUsers();
        return list;
    }

    @RequestMapping("/userUpdate")
    public void userUpdate(@RequestBody Map<String,User> map){
        User user = map.get("user");
        this.userService.updateUser(user);
    }

    @RequestMapping("/userAdd")
    public boolean userAdd(@RequestBody Map<String,User> map){
        boolean f = true;
        User user = map.get("user");
        this.userService.addUser(user);
        return f;
    }

    @RequestMapping("/userSearch")
    public List<User> getSearchUsers(@RequestBody Map<String,String> map){
        List<User> list = this.userService.getSearchUsers(map.get("sname"));
        return list;
    }

    @RequestMapping("/userDelete")
    public void deleteUser(@RequestBody Map<String,Integer> map){
        this.userService.deleteUser(map.get("id"));
    }
}
