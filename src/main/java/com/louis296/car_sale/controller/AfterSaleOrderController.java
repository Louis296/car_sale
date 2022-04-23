package com.louis296.car_sale.controller;

import com.louis296.car_sale.model.dao.User;
import com.louis296.car_sale.model.req.AfterSaleOrderCancelReq;
import com.louis296.car_sale.model.req.AfterSaleOrderCreateReq;
import com.louis296.car_sale.model.req.AfterSaleOrderQuoteReq;
import com.louis296.car_sale.model.resp.Resp;
import com.louis296.car_sale.service.AfterSaleOrderService;
import com.louis296.car_sale.util.RespUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/after_sale_order")
public class AfterSaleOrderController {

    final private AfterSaleOrderService saleOrderService;

    @Autowired
    public AfterSaleOrderController(AfterSaleOrderService saleOrderService) {
        this.saleOrderService = saleOrderService;
    }

    @GetMapping("/list")
    Resp orderList(User user, @RequestParam(value = "Limit")int limit,
                   @RequestParam(value = "Offset")int offset, @RequestParam(value = "Type")int type){
        return saleOrderService.orderList((int) user.getId(),offset,limit,type);
    }

    @PostMapping("/create")
    Resp orderCreate(@RequestBody AfterSaleOrderCreateReq req,@RequestParam(value = "Type")int type,User user){
        return saleOrderService.orderCreate(req,type, (int) user.getId());
    }

    @PostMapping("/cancel")
    Resp orderCancel(@RequestBody AfterSaleOrderCancelReq req){
        return saleOrderService.orderCancel(req.getAfterSaleOrderId());
    }

    @PostMapping("/pay")
    Resp orderPay(@RequestBody AfterSaleOrderCancelReq req){
        return saleOrderService.orderPay(req.getAfterSaleOrderId());
    }

    @PostMapping("/process")
    Resp orderProcess(@RequestBody AfterSaleOrderCancelReq req,User user){
        if (user.getType()!=0){
            return RespUtil.noPermissionResp();
        }
        return saleOrderService.orderProcess(req.getAfterSaleOrderId());
    }

    @PostMapping("/quote")
    Resp orderQuote(@RequestBody AfterSaleOrderQuoteReq req,User user){
        if (user.getType()!=0){
            return RespUtil.noPermissionResp();
        }
        return saleOrderService.orderQuote(req.getAfterSaleOrderId(),req.getPrice());
    }

    @GetMapping("/list_all")
    Resp orderListAll(User user, @RequestParam(value = "Limit")int limit,
                   @RequestParam(value = "Offset")int offset, @RequestParam(value = "Type")int type){
        if(user.getType()!=0){
            return RespUtil.noPermissionResp();
        }
        return saleOrderService.orderList(-1,offset,limit,type);
    }
}
