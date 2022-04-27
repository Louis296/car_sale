package com.louis296.carsalebbsservice.mapper;

import com.louis296.carsalebbsservice.model.dao.Comment;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CommentMapper {
    List<Comment> getCommentsByMomentId(int momentId,int offset,int limit);
    void createComment(Comment comment);
    void softDeleteComment(int id);
    Comment getCommentById(int id);
}
