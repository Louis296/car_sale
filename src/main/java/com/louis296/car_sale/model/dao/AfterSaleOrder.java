package com.louis296.car_sale.model.dao;


import java.util.Date;

public class AfterSaleOrder {

  private long id;
  private double price;
  private long orderStatus;
  private String address;
  private int type;
  private long carId;
  private long saleOrderId;
  private long userId;
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


  public long getOrderStatus() {
    return orderStatus;
  }

  public void setOrderStatus(long orderStatus) {
    this.orderStatus = orderStatus;
  }


  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }


  public int getType() {
    return type;
  }

  public void setType(int type) {
    this.type = type;
  }


  public long getCarId() {
    return carId;
  }

  public void setCarId(long carId) {
    this.carId = carId;
  }


  public long getSaleOrderId() {
    return saleOrderId;
  }

  public void setSaleOrderId(long saleOrderId) {
    this.saleOrderId = saleOrderId;
  }


  public long getUserId() {
    return userId;
  }

  public void setUserId(long userId) {
    this.userId = userId;
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
