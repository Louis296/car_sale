package com.louis296.carsalesaleservice.service;

import com.louis296.carsalesaleservice.model.resp.Resp;

public interface SaleOrderService {
    Resp orderCreate(int carId, int userId, String address);
    Resp orderList(int offset,int limit,int userId);
    Resp orderCancel(long userId,int id);
    Resp orderPay(int id);
    Resp orderProcess(int id);
    Resp orderFinish(int id);
    Resp orderListAll(int offset,int limit);
}
