package com.louis296.carsalesaleservice.model.resp;

import java.util.List;

public class CarListData implements Data{
    List<CarResp> list;

    public List<CarResp> getList() {
        return list;
    }

    public void setList(List<CarResp> list) {
        this.list = list;
    }
}
