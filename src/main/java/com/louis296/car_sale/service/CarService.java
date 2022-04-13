package com.louis296.car_sale.service;

import com.louis296.car_sale.model.req.CarCreateReq;
import com.louis296.car_sale.model.resp.Resp;

public interface CarService {
    Resp carList();
    Resp carCreate(CarCreateReq req);
    Resp carDelete(int id);
}
