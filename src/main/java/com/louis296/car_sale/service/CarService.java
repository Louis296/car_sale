package com.louis296.car_sale.service;

import com.louis296.car_sale.model.req.CarCreateReq;
import com.louis296.car_sale.model.resp.Resp;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

public interface CarService {
    Resp carList();
    Resp carCreate(CarCreateReq req);
    Resp carDelete(int id);
    Resp carSelfList(int userId);
    Resp carImgUpload(MultipartFile file, HttpServletRequest request,int carId);
}
