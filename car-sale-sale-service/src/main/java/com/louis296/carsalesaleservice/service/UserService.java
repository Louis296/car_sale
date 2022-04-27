package com.louis296.carsalesaleservice.service;

import com.louis296.carsalesaleservice.model.req.UserRegisterReq;
import com.louis296.carsalesaleservice.model.resp.Resp;

public interface UserService {
    Resp userLogin(String userId, String password);
    Resp userRegister(UserRegisterReq userRegisterReq);
    Resp userInfo(int id);
}
