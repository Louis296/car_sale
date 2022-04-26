package com.louis296.car_sale.service;

import com.louis296.car_sale.model.resp.Resp;

public interface CommentService {
    Resp commentList(int offset,int limit,int momentId);
    Resp commentCreate(int momentId,String context,int userId);
    Resp commentDelete(int id,int userId);
}
