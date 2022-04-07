package com.louis296.car_sale.model.resp;

public class Resp {
    String status;
    Object data;

    public Resp(Object data){
        this.data=data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
