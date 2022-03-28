package com.example.service;

import com.example.pojo.User;

public interface UserService {
    User queryUserByName(String name);

    void addUser(User user);

    User selectByname(String username);
}
