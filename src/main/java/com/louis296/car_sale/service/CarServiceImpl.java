package com.louis296.car_sale.service;

import com.louis296.car_sale.mapper.CarMapper;
import com.louis296.car_sale.model.dao.Car;
import com.louis296.car_sale.model.req.CarCreateReq;
import com.louis296.car_sale.model.resp.CarListData;
import com.louis296.car_sale.model.resp.CarResp;
import com.louis296.car_sale.model.resp.Data;
import com.louis296.car_sale.model.resp.Resp;
import com.louis296.car_sale.util.RespUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarServiceImpl implements CarService{

    final private CarMapper carMapper;

    @Autowired
    public CarServiceImpl(CarMapper carMapper) {
        this.carMapper = carMapper;
    }

    @Override
    public Resp carList() {
        Resp resp=new Resp();
        try{
            List<Car> list=carMapper.getAllCars();
            List<CarResp> respList=new ArrayList<>();
            for(Car car:list){
                respList.add(new CarResp(car));
            }
            CarListData data=new CarListData();
            data.setList(respList);
            resp.setData(data);
            resp.setStatus("success");
        }catch (Exception e){
            return RespUtil.errorResp("sql error");
        }
        return resp;
    }

    @Override
    @Transactional
    public Resp carCreate(CarCreateReq req) {
        Car car=new Car();
        car.setName(req.getName());
        car.setVersion(req.getVersion());
        car.setDescription(req.getDescription());
        car.setPrice(req.getPrice());
        try{
            carMapper.createCar(car);
        }catch (Exception e){
            return RespUtil.errorResp("sql error");
        }
        return RespUtil.noDataSuccessResp();
    }

    @Override
    public Resp carDelete(int id) {
        try{
            carMapper.softDeleteCar(id);
        }catch (Exception e){
            return RespUtil.errorResp("sql error");
        }
        return RespUtil.noDataSuccessResp();
    }
}
