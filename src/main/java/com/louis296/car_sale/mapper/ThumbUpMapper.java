package com.louis296.car_sale.mapper;

import com.louis296.car_sale.model.dao.ThumbUp;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ThumbUpMapper {
    void createThumbUp(ThumbUp thumbUp);
    ThumbUp getThumbUpByUserIdAndMomentId(int userId,int momentId);
}
