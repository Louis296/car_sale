package com.louis296.car_sale.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.louis296.car_sale.CarSaleApplication;
import com.louis296.car_sale.mapper.UserMapper;
import com.louis296.car_sale.model.dao.User;
import com.louis296.car_sale.model.req.UserRegisterReq;
import com.louis296.car_sale.model.resp.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

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
            User user=userMapper.getUserByUserIdAndPassword(userId, DigestUtils.md5DigestAsHex((password+CarSaleApplication.salt).getBytes()));
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
    public Resp userRegister(UserRegisterReq req) {
        Resp resp=new Resp();
        User user=new User();
        user.setUserName(req.getUserName());
        user.setUserId(req.getUserId());
        user.setPassword(DigestUtils.md5DigestAsHex((req.getPassword()+CarSaleApplication.salt).getBytes()));
        user.setPhone(req.getPhone());
        try{
            userMapper.createUser(user);
            resp.setStatus("success");
        }catch (Exception e){
            resp.setStatus("error");
            resp.setData(new ErrorData("user exists or sql error"));
        }
        return resp;
    }

    @Override
    public Resp userInfo(int id) {
        User user=userMapper.getUserById(id);
        UserInfoData data=new UserInfoData();
        data.setType(user.getType());
        data.setUserName(user.getUserName());
        data.setUserId(user.getUserId());
        data.setPhone(user.getPhone());
        Resp resp=new Resp(data);
        resp.setStatus("success");
        return resp;
    }


}
