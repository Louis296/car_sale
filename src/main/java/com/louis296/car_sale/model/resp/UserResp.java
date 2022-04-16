package com.louis296.car_sale.model.resp;


import com.louis296.car_sale.model.dao.User;

public class UserResp {
    private long id;
    private String userId;
    private String name;
    private String phone;

    public UserResp(User user){
        this.id=user.getId();
        this.userId=user.getUserId();
        this.name=user.getUserName();
        this.phone=user.getPhone();
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
