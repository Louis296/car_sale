package com.louis296.car_sale.mapper;

import com.louis296.car_sale.model.dao.SaleOrder;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SaleOrderMapper {
    void createSaleOrder(SaleOrder saleOrder);
    void changeSaleOrderStatus(int id,int status);
    SaleOrder getSaleOrderById(int id);
    List<SaleOrder> getSaleOrdersByUserId(int limit,int offset,int userId);
    List<SaleOrder> getSaleOrders(int limit,int offset);
    List<SaleOrder> getFinishSaleOrdersByUserId(int id);
}
