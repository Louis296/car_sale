package com.louis296.carsalebbsservice.model.resp;

import com.louis296.carsalebbsservice.model.dao.Moment;

import java.util.Date;

public class MomentResp implements Data{
    long id;
    String context;
    long like;
    String imgUrl;
    Date createTime;
    Date updateTime;
    UserResp user;

    public MomentResp(Moment moment){
        this.id=moment.getId();
        this.context=moment.getContext();
        this.like=moment.getLike();
        this.imgUrl=moment.getImgUrl();
        this.createTime=moment.getCreateTime();
        this.updateTime=moment.getUpdateTime();
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

    public long getLike() {
        return like;
    }

    public void setLike(long like) {
        this.like = like;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
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

    public UserResp getUser() {
        return user;
    }

    public void setUser(UserResp user) {
        this.user = user;
    }
}
