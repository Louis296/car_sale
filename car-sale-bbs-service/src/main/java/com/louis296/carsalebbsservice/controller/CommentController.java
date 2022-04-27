package com.louis296.carsalebbsservice.controller;

import com.louis296.carsalebbsservice.model.dao.User;
import com.louis296.carsalebbsservice.model.req.CommentCreateReq;
import com.louis296.carsalebbsservice.model.req.CommentDeleteReq;
import com.louis296.carsalebbsservice.model.resp.Resp;
import com.louis296.carsalebbsservice.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/comment")
public class CommentController {

    final private CommentService commentService;

    @Autowired
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping("/list")
    Resp commentList(@RequestParam(value = "Offset") int offset,@RequestParam(value = "Limit") int limit,
                     @RequestParam(value = "MomentId") int momentId){
        return commentService.commentList(offset,limit,momentId);
    }

    @PostMapping("/create")
    Resp commentCreate(@RequestBody CommentCreateReq req, User user){
        return commentService.commentCreate(req.getMomentId(),req.getContext(), (int) user.getId());
    }

    @PostMapping("/delete")
    Resp commentDelete(@RequestBody CommentDeleteReq req,User user){
        return commentService.commentDelete(req.getCommentId(), (int) user.getId());
    }
}
