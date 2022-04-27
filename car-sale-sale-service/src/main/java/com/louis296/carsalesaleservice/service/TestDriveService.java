package com.louis296.carsalesaleservice.service;

import com.louis296.carsalesaleservice.model.req.TestDriveCreateReq;
import com.louis296.carsalesaleservice.model.resp.Resp;


public interface TestDriveService {
    Resp testDriveCreate(long userId,TestDriveCreateReq req);
    Resp testDriveList(int userId,int offset,int limit);
    Resp testDriveListAll(int offset,int limit);
    Resp testDriveCancel(int userId, int id);
}
