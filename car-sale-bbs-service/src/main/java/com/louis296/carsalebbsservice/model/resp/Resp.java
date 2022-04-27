package com.louis296.carsalebbsservice.model.resp;

public class Resp {
    String status;
    Data data;

    public Resp(Data data){
        this.data=data;
    }

    public Resp(){}

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Object getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }
}
