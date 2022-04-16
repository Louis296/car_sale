package com.louis296.car_sale.service;

import com.louis296.car_sale.mapper.CarMapper;
import com.louis296.car_sale.mapper.SaleOrderMapper;
import com.louis296.car_sale.model.dao.Car;
import com.louis296.car_sale.model.dao.SaleOrder;
import com.louis296.car_sale.model.req.CarCreateReq;
import com.louis296.car_sale.model.resp.CarListData;
import com.louis296.car_sale.model.resp.CarResp;
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
    final private SaleOrderMapper saleOrderMapper;

    @Autowired
    public CarServiceImpl(CarMapper carMapper, SaleOrderMapper saleOrderMapper) {
        this.carMapper = carMapper;
        this.saleOrderMapper = saleOrderMapper;
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

    @Override
    public Resp carSelfList(int userId) {
        Resp resp=new Resp();
        try{
            List<SaleOrder> orders=saleOrderMapper.getFinishSaleOrdersByUserId(userId);
            List<CarResp> respList=new ArrayList<>();
            for(SaleOrder order:orders){
                Car car=carMapper.getCarById((int) order.getCarId());
                CarResp carResp=new CarResp(car);
                carResp.setOrderId(order.getId());
                respList.add(carResp);
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
}
