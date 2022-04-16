package com.louis296.car_sale.mapper;

import com.louis296.car_sale.model.dao.AfterSaleOrder;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AfterSaleOrderMapper {
    void createOrder(AfterSaleOrder afterSaleOrder);
    void changeOrderStatus(int id,int status);
    List<AfterSaleOrder> getOrdersByUserIdAndType(int userId,int offset,int limit,int type);
    AfterSaleOrder getOrderById(int id);
}
