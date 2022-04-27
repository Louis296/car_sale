package com.louis296.carsalebbsservice.model.dao;


import java.util.Date;

public class ThumbUp {

  private long id;
  private long momentId;
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


  public long getMomentId() {
    return momentId;
  }

  public void setMomentId(long momentId) {
    this.momentId = momentId;
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
