package com.louis296.car_sale.model.req;

public class AfterSaleOrderCreateReq {
    int saleOrderId;
    String address;

    public int getSaleOrderId() {
        return saleOrderId;
    }

    public void setSaleOrderId(int saleOrderId) {
        this.saleOrderId = saleOrderId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
