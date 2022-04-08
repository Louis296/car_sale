package com.louis296.car_sale.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.louis296.car_sale.CarSaleApplication;
import com.louis296.car_sale.mapper.UserMapper;
import com.louis296.car_sale.model.dao.User;
import com.louis296.car_sale.model.req.UserRegisterReq;
import com.louis296.car_sale.model.resp.Data;
import com.louis296.car_sale.model.resp.ErrorData;
import com.louis296.car_sale.model.resp.Resp;
import com.louis296.car_sale.model.resp.UserLoginData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    final private UserMapper userMapper;

    @Autowired
    public UserServiceImpl(UserMapper userMapper){
        this.userMapper=userMapper;
    }

    @Override
    public Resp userLogin(String userId, String password) {
        Resp resp=new Resp();
        try{
            User user=userMapper.getUserByUserIdAndPassword(userId,password);
            String token= JWT.create().withAudience(user.getUserId()).sign(Algorithm.HMAC256(CarSaleApplication.secret));
            UserLoginData userLoginData=new UserLoginData();
            userLoginData.setType(user.getType());
            userLoginData.setToken(token);
            resp.setData(userLoginData);
            resp.setStatus("success");
        }catch (Exception e){
            resp.setData(new ErrorData("user not exist or password wrong"));
            resp.setStatus("error");
        }
        return resp;
    }

    @Override
    public Resp userRegister(UserRegisterReq userRegisterReq) {
        return null;
    }
}
