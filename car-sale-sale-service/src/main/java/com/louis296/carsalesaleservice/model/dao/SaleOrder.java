package com.louis296.carsalesaleservice.model.dao;


import java.util.Date;

public class SaleOrder {

    private long id;
    private double price;
    private long carId;
    private long userId;
    private String address;
    private long saleOrderStatus;
    private Date createTime;
    private Date updateTime;
    private long status;


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


    public long getCarId() {
      return carId;
    }

    public void setCarId(long carId) {
      this.carId = carId;
    }


    public long getUserId() {
      return userId;
    }

    public void setUserId(long userId) {
      this.userId = userId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public long getSaleOrderStatus() {
      return saleOrderStatus;
    }

    public void setSaleOrderStatus(long saleOrderStatus) {
      this.saleOrderStatus = saleOrderStatus;
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

    public long getStatus() {
      return status;
    }

    public void setStatus(long status) {
      this.status = status;
    }

}
