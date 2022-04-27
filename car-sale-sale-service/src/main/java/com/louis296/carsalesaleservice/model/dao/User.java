package com.louis296.carsalesaleservice.model.dao;


import java.util.Date;

public class User {

    private long id;
    private String userId;
    private String password;
    private String userName;
    private String phone;
    private int type;
    private Date createTime;
    private Date updateTime;
    private long status;

    public int getType() {
      return type;
    }

    public void setType(int type) {
      this.type = type;
    }

    public long getId() {
        return id;
      }

    public void setId(long id) {
      this.id = id;
    }


    public String getUserId() {
      return userId;
    }

    public void setUserId(String userId) {
      this.userId = userId;
    }


    public String getPassword() {
      return password;
    }

    public void setPassword(String password) {
      this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPhone() {
      return phone;
    }

    public void setPhone(String phone) {
      this.phone = phone;
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
