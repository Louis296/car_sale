package com.louis296.car_sale.model.resp;

import com.louis296.car_sale.model.dao.Car;


public class CarResp {

    private long id;
    private String name;
    private String version;
    private double price;
    private String description;

    public CarResp(Car car){
        this.id=car.getId();
        this.name=car.getName();
        this.version=car.getVersion();
        this.price=car.getPrice();
        this.description=car.getDescription();
    }

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}