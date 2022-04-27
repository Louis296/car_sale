package com.louis296.carsalebbsservice.mapper;


import com.louis296.carsalebbsservice.model.dao.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    User getUserByUserId(String id);
    User getUserByUserIdAndPassword(String id,String password);
    User getUserById(int id);
    void createUser(User user);

}
