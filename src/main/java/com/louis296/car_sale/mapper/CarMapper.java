package com.louis296.car_sale.mapper;

import com.louis296.car_sale.model.dao.Car;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CarMapper {
    Car getCarById(int id);
}
