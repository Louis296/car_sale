package com.louis296.car_sale.service;

import com.louis296.car_sale.model.req.UserRegisterReq;
import com.louis296.car_sale.model.resp.Data;
import com.louis296.car_sale.model.resp.Resp;
import com.louis296.car_sale.model.resp.UserLoginData;

public interface UserService {
    Resp userLogin(String userId, String password);
    Resp userRegister(UserRegisterReq userRegisterReq);
    Resp userInfo(int id);
}
