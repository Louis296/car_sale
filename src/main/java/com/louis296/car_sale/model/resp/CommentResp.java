package com.louis296.car_sale.model.resp;

import com.louis296.car_sale.model.dao.Comment;

import java.util.Date;

public class CommentResp {
    private long id;
    private String context;
    private UserResp user;
    private long momentId;
    private Date createTime;
    private Date updateTime;

    public CommentResp(Comment comment){
        this.id=comment.getId();
        this.context=comment.getContext();
        this.momentId=comment.getMomentId();
        this.createTime=comment.getCreateTime();
        this.updateTime=comment.getUpdateTime();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public UserResp getUser() {
        return user;
    }

    public void setUser(UserResp user) {
        this.user = user;
    }

    public long getMomentId() {
        return momentId;
    }

    public void setMomentId(long momentId) {
        this.momentId = momentId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
