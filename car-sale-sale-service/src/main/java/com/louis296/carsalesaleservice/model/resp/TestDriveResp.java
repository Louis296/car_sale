package com.louis296.carsalesaleservice.model.resp;

import com.louis296.carsalesaleservice.model.dao.Car;
import com.louis296.carsalesaleservice.model.dao.TestDrive;

import java.util.Date;

public class TestDriveResp {
    private long id;
    private String address;
    private String phone;
    private Date createTime;
    private Date updateTime;
    private Car car;

    public TestDriveResp(TestDrive testDrive){
        this.id=testDrive.getId();
        this.address=testDrive.getAddress();
        this.phone= testDrive.getPhone();
        this.createTime=testDrive.getCreateTime();
        this.updateTime=testDrive.getUpdateTime();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }
}
