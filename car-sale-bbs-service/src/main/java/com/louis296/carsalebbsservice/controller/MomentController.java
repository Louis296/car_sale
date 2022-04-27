package com.louis296.carsalebbsservice.controller;

import com.louis296.carsalebbsservice.model.dao.User;
import com.louis296.carsalebbsservice.model.req.MomentDeleteReq;
import com.louis296.carsalebbsservice.model.resp.Resp;
import com.louis296.carsalebbsservice.service.MomentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/moment")
public class MomentController {

    final private MomentService momentService;

    @Autowired
    public MomentController(MomentService momentService) {
        this.momentService = momentService;
    }

    @GetMapping("/list")
    Resp momentList(@RequestParam(value = "Limit") int limit, @RequestParam(value = "Offset") int offset){
        return momentService.momentList(-1,offset,limit);
    }

    @GetMapping("/self_list")
    Resp momentSelfList(@RequestParam(value = "Limit") int limit, @RequestParam(value = "Offset") int offset, User user){
        return momentService.momentList((int) user.getId(),offset,limit);
    }

    @PostMapping("/create")
    Resp momentCreate(@RequestParam("files") MultipartFile[] files, @RequestParam("context") String context,
                      User user, HttpServletRequest request){
        return momentService.momentCreate(files,context, (int) user.getId(),request);
    }

    @PostMapping("/delete")
    Resp momentDelete(@RequestBody MomentDeleteReq req,User user){
        return momentService.momentDelete(req.getMomentId(), (int) user.getId());
    }

    @PostMapping("/thumb_up")
    Resp momentThumbUp(@RequestBody MomentDeleteReq req,User user){
        return momentService.momentThumbUp(req.getMomentId(), (int) user.getId());
    }
}
