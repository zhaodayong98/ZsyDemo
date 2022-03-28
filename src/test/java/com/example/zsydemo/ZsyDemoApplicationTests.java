package com.example.zsydemo;

import com.example.pojo.User;
import com.example.service.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ZsyDemoApplicationTests {
    @Autowired
    UserServiceImpl userService;
    @Test
    void contextLoads() {
        System.out.println(userService.queryUserByName("ay"));
        User user=new User(null,"aa","1",null);
         userService.addUser(user);
    }

}
