package com.louis296.car_sale.service;

import com.louis296.car_sale.model.resp.UserLoginData;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    @Override
    public UserLoginData userLogin(String userId, String password) {
        UserLoginData data=new UserLoginData();
        data.setToken("test:"+userId);
        data.setType("test:"+password);
        return data;
    }
}
