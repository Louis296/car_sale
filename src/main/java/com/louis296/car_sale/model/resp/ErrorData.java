package com.louis296.car_sale.model.resp;

public class ErrorData implements Data {
    String error;

    public ErrorData(String error){
        this.error=error;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
