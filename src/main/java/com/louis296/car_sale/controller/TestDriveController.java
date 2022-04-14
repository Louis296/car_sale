package com.louis296.car_sale.controller;

import com.louis296.car_sale.model.dao.User;
import com.louis296.car_sale.model.req.TestDriveCreateReq;
import com.louis296.car_sale.model.req.TestDriveCancelReq;
import com.louis296.car_sale.model.resp.Resp;
import com.louis296.car_sale.service.TestDriveService;
import com.louis296.car_sale.util.RespUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/test_drive")
public class TestDriveController {

    final private TestDriveService testDriveService;

    @Autowired
    public TestDriveController(TestDriveService testDriveService) {
        this.testDriveService = testDriveService;
    }


    @PostMapping("/create")
    Resp testDriveCreate(User user, @RequestBody TestDriveCreateReq req){
        return testDriveService.testDriveCreate(user.getId(),req);
    }

    @GetMapping("/list")
    Resp testDriveList(User user,@RequestParam(value = "Limit")int limit,@RequestParam(value = "Offset")int offset){
        return testDriveService.testDriveList((int) user.getId(),offset,limit);
    }

    @GetMapping("/list_all")
    Resp testDriveListAll(User user,@RequestParam(value = "Limit")int limit,@RequestParam(value = "Offset")int offset){
        if(user.getType()!=0){
            return RespUtil.noPermissionResp();
        }
        return testDriveService.testDriveListAll(offset,limit);
    }

    @PostMapping("/cancel")
    Resp testDriveCancel(User user, @RequestBody TestDriveCancelReq req){
        return testDriveService.testDriveCancel((int) user.getId(),req.getId());
    }
}
