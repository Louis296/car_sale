package com.louis296.car_sale.model.resp;

import java.util.List;

public class CommentListData implements Data{
    int offset;
    int limit;
    List<CommentResp> list;

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

    public List<CommentResp> getList() {
        return list;
    }

    public void setList(List<CommentResp> list) {
        this.list = list;
    }
}
