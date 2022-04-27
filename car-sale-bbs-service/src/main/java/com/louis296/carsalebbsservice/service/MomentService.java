package com.louis296.carsalebbsservice.service;

import com.louis296.carsalebbsservice.model.resp.Resp;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

public interface MomentService {
    Resp momentList(int userId,int offset,int limit);
    Resp momentCreate(MultipartFile[] files, String context, int userId, HttpServletRequest request);
    Resp momentDelete(int momentId,int userId);
    Resp momentThumbUp(int momentId,int userId);
}
