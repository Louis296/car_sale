package com.louis296.car_sale.model.req;

public class CommentCreateReq {
    int momentId;
    String context;

    public int getMomentId() {
        return momentId;
    }

    public void setMomentId(int momentId) {
        this.momentId = momentId;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }
}
