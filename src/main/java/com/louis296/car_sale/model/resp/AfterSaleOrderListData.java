package com.louis296.car_sale.model.resp;

import java.util.List;

public class AfterSaleOrderListData implements Data{
    int offset;
    int limit;
    List<AfterSaleOrderResp> list;

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

    public List<AfterSaleOrderResp> getList() {
        return list;
    }

    public void setList(List<AfterSaleOrderResp> list) {
        this.list = list;
    }
}
