package com.louis296.carsalesaleservice.mapper;

import com.louis296.carsalesaleservice.model.dao.TestDrive;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TestDriveMapper {
    void createTestDrive(TestDrive testDrive);
    List<TestDrive> getTestDrivesByUserId(int id,int limit,int offset);
    List<TestDrive> getAllTestDrives(int limit,int offset);
    void deleteTestDrive(int id);
    TestDrive getTestDriveById(int id);
}
