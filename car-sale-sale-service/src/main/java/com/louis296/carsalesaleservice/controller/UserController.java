package com.louis296.carsalesaleservice.controller;

import com.louis296.carsalesaleservice.model.dao.User;
import com.louis296.carsalesaleservice.model.req.UserLoginReq;
import com.louis296.carsalesaleservice.model.req.UserRegisterReq;
import com.louis296.carsalesaleservice.model.resp.Resp;
import com.louis296.carsalesaleservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    final private UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService=userService;
    }

    @PostMapping("/login")
    Resp userLogin(@RequestBody UserLoginReq userLoginReq) {
        return userService.userLogin(userLoginReq.getUserId(),userLoginReq.getPassword());
    }

    @PostMapping("/register")
    Resp userRegister(@RequestBody UserRegisterReq userRegisterReq){
        return userService.userRegister(userRegisterReq);
    }

    @GetMapping("/info")
    Resp userInfo(User user){
        return userService.userInfo((int) user.getId());
    }
}
