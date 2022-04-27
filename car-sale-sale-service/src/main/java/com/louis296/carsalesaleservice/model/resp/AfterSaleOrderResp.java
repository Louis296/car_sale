package com.louis296.carsalesaleservice.model.resp;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.louis296.carsalesaleservice.model.dao.AfterSaleOrder;

import java.util.Date;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class AfterSaleOrderResp implements Data{
    private long id;
    private double price;
    private long status;
    private String address;
    private long saleOrderId;
    private Date createTime;
    private Date updateTime;
    private CarResp carResp;
    private UserResp userResp;

    public AfterSaleOrderResp(AfterSaleOrder afterSaleOrder){
        this.id=afterSaleOrder.getId();
        this.price=afterSaleOrder.getPrice();
        this.status=afterSaleOrder.getOrderStatus();
        this.address=afterSaleOrder.getAddress();
        this.saleOrderId=afterSaleOrder.getSaleOrderId();
        this.createTime=afterSaleOrder.getCreateTime();
        this.updateTime=afterSaleOrder.getUpdateTime();
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

    public long getStatus() {
        return status;
    }

    public void setStatus(long status) {
        this.status = status;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public long getSaleOrderId() {
        return saleOrderId;
    }

    public void setSaleOrderId(long saleOrderId) {
        this.saleOrderId = saleOrderId;
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

    public CarResp getCarResp() {
        return carResp;
    }

    public void setCarResp(CarResp carResp) {
        this.carResp = carResp;
    }

    public UserResp getUserResp() {
        return userResp;
    }

    public void setUserResp(UserResp userResp) {
        this.userResp = userResp;
    }
}
