package com.louis296.carsalesaleservice.mapper;

import com.louis296.carsalesaleservice.model.dao.Car;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CarMapper {
    Car getCarById(int id);
    List<Car> getAllCars();
    void createCar(Car car);
    void softDeleteCar(int id);
    void setCarImg(String img,int id);
}
