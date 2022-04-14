package com.louis296.car_sale.model.resp;

import java.util.List;

public class TestDriveListData implements Data {
    int limit;
    int offset;
    List<TestDriveResp> list;

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public List<TestDriveResp> getList() {
        return list;
    }

    public void setList(List<TestDriveResp> list) {
        this.list = list;
    }
}
