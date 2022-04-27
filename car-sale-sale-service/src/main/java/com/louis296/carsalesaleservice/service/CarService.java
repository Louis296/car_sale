package com.louis296.carsalesaleservice.service;

import com.louis296.carsalesaleservice.model.req.CarCreateReq;
import com.louis296.carsalesaleservice.model.resp.Resp;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

public interface CarService {
    Resp carList();
    Resp carCreate(CarCreateReq req);
    Resp carDelete(int id);
    Resp carSelfList(int userId);
    Resp carImgUpload(MultipartFile file, HttpServletRequest request,int carId);
}
