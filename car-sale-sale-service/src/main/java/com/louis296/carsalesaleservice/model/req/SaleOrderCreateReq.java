package com.louis296.carsalesaleservice.model.req;

public class SaleOrderCreateReq {
    int carId;
    String address;

    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
