package com.louis296.carsalebbsservice.mapper;

import com.louis296.carsalebbsservice.model.dao.Moment;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MomentMapper {
    void createMoment(Moment moment);
    void softDeleteMoment(int id);
    List<Moment> getMomentsByUserId(int userId,int offset,int limit);
    List<Moment> getAllMoments(int offset,int limit);
    Moment getMomentById(int id);
    void changeMomentLike(int like,int id);
}
