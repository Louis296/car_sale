package com.louis296.car_sale.controller;

import com.louis296.car_sale.model.dao.User;
import com.louis296.car_sale.model.req.CarCreateReq;
import com.louis296.car_sale.model.req.CarDeleteReq;
import com.louis296.car_sale.model.resp.Resp;
import com.louis296.car_sale.service.CarService;
import com.louis296.car_sale.util.RespUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/car")
public class CarController {

    final private CarService carService;

    @Autowired
    public CarController(CarService carService){
        this.carService=carService;
    }

    @GetMapping("/list")
    Resp carList(User user){
        return carService.carList();
    }

    @PostMapping("/delete")
    Resp carDelete(User user, @RequestBody CarDeleteReq req) {
        if(user.getType()!=0){
            return RespUtil.noPermissionResp();
        }
        return carService.carDelete(req.getCarId());
    }

    @PostMapping("/create")
    Resp carCreate(User user, @RequestBody CarCreateReq req){
        if(user.getType()!=0){
            return RespUtil.noPermissionResp();
        }
        return carService.carCreate(req);
    }

    @GetMapping("/self_list")
    Resp carSelfList(User user){
        return carService.carSelfList((int) user.getId());
    }
}
