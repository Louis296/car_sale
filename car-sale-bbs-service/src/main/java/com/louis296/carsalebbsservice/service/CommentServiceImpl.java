package com.louis296.carsalebbsservice.service;

import com.louis296.carsalebbsservice.mapper.CommentMapper;
import com.louis296.carsalebbsservice.mapper.UserMapper;
import com.louis296.carsalebbsservice.model.dao.Comment;
import com.louis296.carsalebbsservice.model.resp.CommentListData;
import com.louis296.carsalebbsservice.model.resp.CommentResp;
import com.louis296.carsalebbsservice.model.resp.Resp;
import com.louis296.carsalebbsservice.model.resp.UserResp;
import com.louis296.carsalebbsservice.util.RespUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentService{

    final private CommentMapper commentMapper;
    final private UserMapper userMapper;

    @Autowired
    public CommentServiceImpl(CommentMapper commentMapper, UserMapper userMapper) {
        this.commentMapper = commentMapper;
        this.userMapper = userMapper;
    }


    @Override
    public Resp commentList(int offset, int limit, int momentId) {
        Resp resp=new Resp();
        try{
            List<Comment> list=commentMapper.getCommentsByMomentId(momentId,limit*(offset-1),limit);
            List<CommentResp> respList=new ArrayList<>();
            for(Comment comment:list){
                CommentResp commentResp=new CommentResp(comment);
                commentResp.setUser(new UserResp(userMapper.getUserById((int) comment.getUserId())));
                respList.add(commentResp);
            }
            CommentListData data=new CommentListData();
            data.setLimit(limit);
            data.setOffset(offset);
            data.setList(respList);

            resp.setData(data);
            resp.setStatus("success");
        }catch (Exception e){
            return RespUtil.errorResp("sql error");
        }
        return resp;
    }

    @Override
    public Resp commentCreate(int momentId, String context, int userId) {
        try{
            Comment comment=new Comment();
            comment.setMomentId(momentId);
            comment.setContext(context);
            comment.setUserId(userId);
            commentMapper.createComment(comment);
        }catch (Exception e){
            return RespUtil.errorResp("sql error");
        }
        return RespUtil.noDataSuccessResp();
    }

    @Override
    public Resp commentDelete(int id, int userId) {
        try{
            Comment comment=commentMapper.getCommentById(id);
            if(comment.getUserId()!=userId){
                return RespUtil.errorResp("comment "+id+" cannot delete by user "+userId);
            }
            commentMapper.softDeleteComment(id);
        }catch (Exception e){
            return RespUtil.errorResp("sql error");
        }
        return RespUtil.noDataSuccessResp();
    }


}
