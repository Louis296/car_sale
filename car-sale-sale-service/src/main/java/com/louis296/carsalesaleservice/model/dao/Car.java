package com.louis296.carsalesaleservice.model.dao;


import java.util.Date;

public class Car {

    private long id;
    private String name;
    private String version;
    private double price;
    private String imgUrl;
    private String description;
    private Date createTime;
    private Date updateTime;
    private long status;


    public long getId() {
      return id;
    }

    public void setId(long id) {
      this.id = id;
    }


    public String getName() {
      return name;
    }

    public void setName(String name) {
      this.name = name;
    }


    public String getVersion() {
      return version;
    }

    public void setVersion(String version) {
      this.version = version;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getDescription() {
      return description;
    }

    public void setDescription(String description) {
      this.description = description;
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
