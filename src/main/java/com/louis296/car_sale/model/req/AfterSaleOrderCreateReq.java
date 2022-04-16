package com.louis296.car_sale.model.req;

public class AfterSaleOrderCreateReq {
    int afterSaleOrderId;
    String address;

    public int getAfterSaleOrderId() {
        return afterSaleOrderId;
    }

    public void setAfterSaleOrderId(int afterSaleOrderId) {
        this.afterSaleOrderId = afterSaleOrderId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
