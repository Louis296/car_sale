package com.louis296.car_sale.service;

import com.louis296.car_sale.model.resp.Resp;

public interface SaleOrderService {
    Resp orderCreate(int carId, int userId, String address);
    Resp orderList(int offset,int limit,int userId);
    Resp orderCancel(long userId,int id);
    Resp orderPay(int id);
}
