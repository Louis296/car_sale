package com.louis296.car_sale.service;

import com.louis296.car_sale.model.resp.UserLoginData;

public interface UserService {
    UserLoginData userLogin(String userId,String password);
}
