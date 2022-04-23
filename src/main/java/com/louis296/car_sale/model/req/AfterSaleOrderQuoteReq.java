package com.louis296.car_sale.model.req;

public class AfterSaleOrderQuoteReq {
    int afterSaleOrderId;
    double price;

    public int getAfterSaleOrderId() {
        return afterSaleOrderId;
    }

    public void setAfterSaleOrderId(int afterSaleOrderId) {
        this.afterSaleOrderId = afterSaleOrderId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
