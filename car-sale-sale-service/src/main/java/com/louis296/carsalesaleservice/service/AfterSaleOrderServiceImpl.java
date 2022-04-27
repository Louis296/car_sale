package com.louis296.carsalesaleservice.service;

import com.louis296.carsalesaleservice.mapper.AfterSaleOrderMapper;
import com.louis296.carsalesaleservice.mapper.CarMapper;
import com.louis296.carsalesaleservice.mapper.SaleOrderMapper;
import com.louis296.carsalesaleservice.mapper.UserMapper;
import com.louis296.carsalesaleservice.model.dao.AfterSaleOrder;
import com.louis296.carsalesaleservice.model.dao.SaleOrder;
import com.louis296.carsalesaleservice.model.req.AfterSaleOrderCreateReq;
import com.louis296.carsalesaleservice.model.resp.*;
import com.louis296.carsalesaleservice.util.RespUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class AfterSaleOrderServiceImpl implements AfterSaleOrderService{

    final private AfterSaleOrderMapper afterSaleOrderMapper;
    final private SaleOrderMapper saleOrderMapper;
    final private CarMapper carMapper;
    final private UserMapper userMapper;

    @Autowired
    public AfterSaleOrderServiceImpl(AfterSaleOrderMapper afterSaleOrderMapper, SaleOrderMapper saleOrderMapper,
                                     CarMapper carMapper, UserMapper userMapper) {
        this.afterSaleOrderMapper = afterSaleOrderMapper;
        this.saleOrderMapper = saleOrderMapper;
        this.carMapper = carMapper;
        this.userMapper = userMapper;
    }

    @Override
    @Transactional
    public Resp orderCreate(AfterSaleOrderCreateReq req,int type,int userId) {
        Resp resp=new Resp();
        try{
            SaleOrder saleOrder=saleOrderMapper.getSaleOrderById(req.getSaleOrderId());
            if(saleOrder.getUserId()!=userId){
                return RespUtil.errorResp("sale order "+saleOrder.getId()+" do not belong to user "+userId);
            }
            AfterSaleOrder afterSaleOrder=new AfterSaleOrder();
            afterSaleOrder.setAddress(req.getAddress());
            afterSaleOrder.setType(type);
            afterSaleOrder.setCarId(saleOrder.getCarId());
            afterSaleOrder.setSaleOrderId(saleOrder.getId());
            afterSaleOrder.setUserId(saleOrder.getUserId());

            afterSaleOrderMapper.createOrder(afterSaleOrder);

            AfterSaleOrderResp orderResp=new AfterSaleOrderResp(afterSaleOrder);
            orderResp.setCarResp(new CarResp(carMapper.getCarById((int) saleOrder.getCarId())));
            orderResp.setUserResp(new UserResp(userMapper.getUserById(userId)));

            resp.setData(orderResp);
            resp.setStatus("success");
        }catch (Exception e){
            return RespUtil.errorResp("sql error");
        }
        return resp;
    }

    @Override
    public Resp orderCancel(int orderId) {
        try{
            AfterSaleOrder order= afterSaleOrderMapper.getOrderById(orderId);
            if(order.getOrderStatus()!=0){
                return RespUtil.errorResp("order with status "+order.getOrderStatus()+" cannot cancel");
            }
            afterSaleOrderMapper.changeOrderStatus(orderId,-1);
        }catch (Exception e){
            return RespUtil.errorResp("sql error");
        }
        return RespUtil.noDataSuccessResp();
    }

    @Override
    public Resp orderList(int userId, int offset, int limit, int type) {
        Resp resp=new Resp();
        try{
            List<AfterSaleOrder> list;
            if(userId!=-1){
                list=afterSaleOrderMapper.getOrdersByUserIdAndType(userId,limit*(offset-1),limit,type);
            }else{
                list=afterSaleOrderMapper.getAllOrders(limit*(offset-1),limit,type);
            }

            List<AfterSaleOrderResp> respList=new ArrayList<>();
            for(AfterSaleOrder order:list){
                AfterSaleOrderResp orderResp=new AfterSaleOrderResp(order);
                orderResp.setCarResp(new CarResp(carMapper.getCarById((int) order.getCarId())));
                orderResp.setUserResp(new UserResp(userMapper.getUserById((int) order.getUserId())));
                respList.add(orderResp);
            }

            AfterSaleOrderListData data=new AfterSaleOrderListData();
            data.setLimit(limit);
            data.setOffset(offset);
            data.setList(respList);
            resp.setData(data);
            resp.setStatus("success");
        }catch (Exception e){
            return RespUtil.errorResp("sql error");
        }
        return resp;
    }

    @Override
    public Resp orderPay(int orderId) {
        try{
            AfterSaleOrder afterSaleOrder=afterSaleOrderMapper.getOrderById(orderId);
            if(afterSaleOrder.getOrderStatus()!=2){
                return RespUtil.errorResp("order with status "+afterSaleOrder.getOrderStatus()+" cannot pay");
            }
            afterSaleOrderMapper.changeOrderStatus(orderId,3);
        }catch (Exception e){
            return RespUtil.errorResp("sql error");
        }
        return RespUtil.noDataSuccessResp();
    }

    @Override
    public Resp orderProcess(int orderId) {
        try{
            AfterSaleOrder afterSaleOrder=afterSaleOrderMapper.getOrderById(orderId);
            if(afterSaleOrder.getOrderStatus()!=0){
                return RespUtil.errorResp("order with status "+afterSaleOrder.getOrderStatus()+" cannot process");
            }
            afterSaleOrderMapper.changeOrderStatus(orderId,1);
        }catch (Exception e){
            return RespUtil.errorResp("sql error");
        }
        return RespUtil.noDataSuccessResp();
    }

    @Override
    public Resp orderQuote(int orderId, double price) {
        try{
            AfterSaleOrder afterSaleOrder=afterSaleOrderMapper.getOrderById(orderId);
            if(afterSaleOrder.getOrderStatus()!=1){
                return RespUtil.errorResp("order with status "+afterSaleOrder.getOrderStatus()+" cannot quote");
            }
            afterSaleOrderMapper.changeOrderStatus(orderId,2);
            afterSaleOrderMapper.setOrderPrice(orderId,price);
        }catch (Exception e){
            return RespUtil.errorResp("sql error");
        }
        return RespUtil.noDataSuccessResp();
    }
}
