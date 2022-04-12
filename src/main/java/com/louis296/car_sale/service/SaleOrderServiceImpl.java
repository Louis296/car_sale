package com.louis296.car_sale.service;

import com.louis296.car_sale.mapper.CarMapper;
import com.louis296.car_sale.mapper.SaleOrderMapper;
import com.louis296.car_sale.model.dao.Car;
import com.louis296.car_sale.model.dao.SaleOrder;
import com.louis296.car_sale.model.resp.ErrorData;
import com.louis296.car_sale.model.resp.Resp;
import com.louis296.car_sale.model.resp.SaleOrderListData;
import com.louis296.car_sale.model.resp.SaleOrderResp;
import com.louis296.car_sale.util.RespUtil;
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

}
