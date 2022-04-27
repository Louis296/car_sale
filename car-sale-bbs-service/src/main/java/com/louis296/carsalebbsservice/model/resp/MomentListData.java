package com.louis296.carsalebbsservice.model.resp;

import java.util.List;

public class MomentListData implements Data{
    int offset;
    int limit;
    List<MomentResp> list;

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public List<MomentResp> getList() {
        return list;
    }

    public void setList(List<MomentResp> list) {
        this.list = list;
    }
}
