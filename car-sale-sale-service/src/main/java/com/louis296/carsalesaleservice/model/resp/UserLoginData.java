package com.louis296.carsalesaleservice.model.resp;

public class UserLoginData implements Data{
    String token;
    int type;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
