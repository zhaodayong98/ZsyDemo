package com.example.mapper;

import com.example.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface UserMapper {

    int deleteByPrimaryKey(Integer id);


    int insert(User record);


    User selectByPrimaryKey(Integer id);


    List<User> selectAll();

    int updateByPrimaryKey(User record);

    User queryUserByName(String name);
}