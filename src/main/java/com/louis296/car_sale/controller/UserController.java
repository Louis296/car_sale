package com.louis296.car_sale.controller;

import com.louis296.car_sale.model.req.UserLoginReq;
import com.louis296.car_sale.model.req.UserRegisterReq;
import com.louis296.car_sale.model.resp.Resp;
import com.louis296.car_sale.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    final private UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService=userService;
    }

    @PostMapping("/login")
    Resp userLogin(@RequestBody UserLoginReq userLoginReq){
        Resp resp=new Resp(userService.userLogin(userLoginReq.getUserId(),userLoginReq.getPassword()));
        resp.setStatus("success");
        return resp;
    }

    @PostMapping("/register")
    Resp userRegister(@RequestBody UserRegisterReq userRegisterReq){
        return null;
    }
}
