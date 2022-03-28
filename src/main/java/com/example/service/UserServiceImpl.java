package com.example.service;

import com.example.mapper.UserMapper;
import com.example.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class UserServiceImpl implements UserService{
    @Autowired
    UserMapper userMapper;
    @Override
    public User queryUserByName(String name) {
        return userMapper.queryUserByName(name);
    }

    @Override
    public void addUser(User user) {
        userMapper.insert(user);
    }

    @Override
    public User selectByname(String username) {
        return null;
    }

//    @Override
//    public User selectByname(String username) {
//        List<User> list=userMapper.selectAll();
//        return userMapper.selectAll();
//    }
}
