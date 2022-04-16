package com.louis296.car_sale.service;

import com.louis296.car_sale.model.req.AfterSaleOrderCreateReq;
import com.louis296.car_sale.model.resp.Resp;

public interface AfterSaleOrderService {
    Resp orderCreate(AfterSaleOrderCreateReq req,int type,int userId);
    Resp orderCancel(int orderId);
    Resp orderList(int userId,int offset,int limit,int type);
}
