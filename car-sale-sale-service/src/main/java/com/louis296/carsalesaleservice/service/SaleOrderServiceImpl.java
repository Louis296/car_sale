package com.louis296.carsalesaleservice.service;

import com.louis296.carsalesaleservice.mapper.CarMapper;
import com.louis296.carsalesaleservice.mapper.SaleOrderMapper;
import com.louis296.carsalesaleservice.model.dao.Car;
import com.louis296.carsalesaleservice.model.dao.SaleOrder;
import com.louis296.carsalesaleservice.model.resp.Resp;
import com.louis296.carsalesaleservice.model.resp.SaleOrderListData;
import com.louis296.carsalesaleservice.model.resp.SaleOrderResp;
import com.louis296.carsalesaleservice.util.RespUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class SaleOrderServiceImpl implements SaleOrderService{

    final private CarMapper carMapper;
    final private SaleOrderMapper saleOrderMapper;

    @Autowired
    public SaleOrderServiceImpl(CarMapper carMapper,SaleOrderMapper saleOrderMapper){
        this.carMapper=carMapper;
        this.saleOrderMapper=saleOrderMapper;
    }

    @Override
    @Transactional
    public Resp orderCreate(int carId, int userId, String address) {
        Resp resp=new Resp();
        try {
            SaleOrder saleOrder=new SaleOrder();
            saleOrder.setAddress(address);
            saleOrder.setCarId(carId);
            saleOrder.setUserId(userId);
            Car car=carMapper.getCarById(carId);
            saleOrder.setPrice(car.getPrice());
            saleOrderMapper.createSaleOrder(saleOrder);
            SaleOrderResp data=new SaleOrderResp(saleOrderMapper.getSaleOrderById((int) saleOrder.getId()));
            data.setCar(car);
            resp.setData(data);
            resp.setStatus("success");
        }catch (Exception e){
            return RespUtil.errorResp("no such car or sql error");
        }
        return resp;
    }

    @Override
    public Resp orderList(int offset, int limit, int userId) {
        Resp resp=new Resp();
        List<SaleOrder> list=saleOrderMapper.getSaleOrdersByUserId(limit,limit*(offset-1),userId);
        List<SaleOrderResp> respList=new ArrayList<>();
        for(SaleOrder order:list){
            SaleOrderResp item=new SaleOrderResp(order);
            item.setCar(carMapper.getCarById((int) order.getCarId()));
            respList.add(item);
        }
        SaleOrderListData data=new SaleOrderListData();
        data.setList(respList);
        data.setLimit(limit);
        data.setOffset(offset);
        resp.setData(data);
        resp.setStatus("success");
        return resp;
    }

    @Override
    public Resp orderCancel(long userId,int id) {
        Resp resp=new Resp();
        try{
            SaleOrder order=saleOrderMapper.getSaleOrderById(id);
            if(order.getSaleOrderStatus()!=0&&order.getSaleOrderStatus()!=1){
                return RespUtil.errorResp("sale order "+order.getId()+" cannot cancel");
            }
            if(order.getUserId()!=userId){
                return RespUtil.errorResp("sale order "+order.getId()+" cannot cancel by user "+userId);
            }
            saleOrderMapper.changeSaleOrderStatus((int) order.getId(),-1);
        }catch (Exception e){
            return RespUtil.errorResp("sql error");
        }
        resp.setStatus("success");
        return resp;
    }

    @Override
    public Resp orderPay(int id) {
        Resp resp=new Resp();
        try{
            SaleOrder order=saleOrderMapper.getSaleOrderById(id);
            if(order.getSaleOrderStatus()!=0){
                return RespUtil.errorResp("sale order with status "+order.getSaleOrderStatus()+" cannot pay");
            }
            saleOrderMapper.changeSaleOrderStatus((int) order.getId(),1);
        }catch (Exception e){
            return RespUtil.errorResp("sql error");
        }
        resp.setStatus("success");
        return resp;
    }

    @Override
    public Resp orderProcess(int id) {
        Resp resp=new Resp();
        try{
            SaleOrder order=saleOrderMapper.getSaleOrderById(id);
            if(order.getSaleOrderStatus()!=1){
                return RespUtil.errorResp("sale order with status "+order.getSaleOrderStatus()+" cannot process");
            }
            saleOrderMapper.changeSaleOrderStatus((int)order.getId(),2);
        }catch (Exception e){
            return RespUtil.errorResp("sql error");
        }
        resp.setStatus("success");
        return resp;
    }

    @Override
    public Resp orderFinish(int id) {
        Resp resp=new Resp();
        try{
            SaleOrder order=saleOrderMapper.getSaleOrderById(id);
            if(order.getSaleOrderStatus()!=2){
                return RespUtil.errorResp("sale order with status "+order.getSaleOrderStatus()+" cannot finish");
            }
            saleOrderMapper.changeSaleOrderStatus((int)order.getId(),3);
        }catch (Exception e){
            return RespUtil.errorResp("sql error");
        }
        resp.setStatus("success");
        return resp;
    }

    @Override
    public Resp orderListAll(int offset, int limit) {
        Resp resp=new Resp();
        List<SaleOrder> list=saleOrderMapper.getSaleOrders(limit,limit*(offset-1));
        List<SaleOrderResp> respList=new ArrayList<>();
        for(SaleOrder order:list){
            SaleOrderResp item=new SaleOrderResp(order);
            item.setCar(carMapper.getCarById((int) order.getCarId()));
            respList.add(item);
        }
        SaleOrderListData data=new SaleOrderListData();
        data.setList(respList);
        data.setLimit(limit);
        data.setOffset(offset);
        resp.setData(data);
        resp.setStatus("success");
        return resp;
    }

}
