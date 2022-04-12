package com.louis296.car_sale.controller;

import com.louis296.car_sale.model.dao.SaleOrder;
import com.louis296.car_sale.model.dao.User;
import com.louis296.car_sale.model.req.SaleOrderCancelReq;
import com.louis296.car_sale.model.req.SaleOrderCreateReq;
import com.louis296.car_sale.model.req.SaleOrderPayReq;
import com.louis296.car_sale.model.resp.Resp;
import com.louis296.car_sale.service.SaleOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sale_order")
public class SaleOrderController {

    final private SaleOrderService saleOrderService;

    @Autowired
    public SaleOrderController(SaleOrderService saleOrderService){
        this.saleOrderService=saleOrderService;
    }

    @GetMapping("/list")
    Resp orderList(User user, @RequestParam(value = "Limit")int limit,@RequestParam(value = "Offset")int offset) {
        return saleOrderService.orderList(offset,limit, (int) user.getId());
    }

    @PostMapping("/create")
    Resp orderCreate(User user, @RequestBody SaleOrderCreateReq req){
        return saleOrderService.orderCreate(req.getCarId(), (int) user.getId(),req.getAddress());
    }

    @PostMapping("/cancel")
    Resp orderCancel(User user, @RequestBody SaleOrderCancelReq req){
        return saleOrderService.orderCancel(user.getId(),req.getOrderId());
    }

    @PostMapping("/pay")
    Resp orderPay(User user, @RequestBody SaleOrderPayReq req){
        return saleOrderService.orderPay(req.getOrderId());
    }
}
