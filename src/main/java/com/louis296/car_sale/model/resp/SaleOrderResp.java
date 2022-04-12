package com.louis296.car_sale.model.resp;

import com.louis296.car_sale.model.dao.Car;
import com.louis296.car_sale.model.dao.SaleOrder;

import java.util.Date;

public class SaleOrderResp {

    private long id;
    private double price;
    private String address;
    private long status;
    private Date createTime;
    private Date updateTime;
    private Car car;

    public SaleOrderResp(SaleOrder saleOrder){
        this.id=saleOrder.getId();
        this.price=saleOrder.getPrice();
        this.address=saleOrder.getAddress();
        this.status=saleOrder.getSaleOrderStatus();
        this.createTime=saleOrder.getCreateTime();
        this.updateTime=saleOrder.getUpdateTime();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public long getStatus() {
        return status;
    }

    public void setStatus(long status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }
}
