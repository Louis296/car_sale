package com.louis296.carsalesaleservice.service;

import com.louis296.carsalesaleservice.mapper.CarMapper;
import com.louis296.carsalesaleservice.mapper.TestDriveMapper;
import com.louis296.carsalesaleservice.model.dao.TestDrive;
import com.louis296.carsalesaleservice.model.req.TestDriveCreateReq;
import com.louis296.carsalesaleservice.model.resp.Resp;
import com.louis296.carsalesaleservice.model.resp.TestDriveListData;
import com.louis296.carsalesaleservice.model.resp.TestDriveResp;
import com.louis296.carsalesaleservice.util.RespUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class TestDriveServiceImpl implements TestDriveService{

    final private TestDriveMapper testDriveMapper;
    final private CarMapper carMapper;

    @Autowired
    public TestDriveServiceImpl(TestDriveMapper testDriveMapper, CarMapper carMapper) {
        this.testDriveMapper = testDriveMapper;
        this.carMapper = carMapper;
    }


    @Override
    @Transactional
    public Resp testDriveCreate(long userId,TestDriveCreateReq req) {
        try{
            carMapper.getCarById(req.getCarId());
            TestDrive testDrive=new TestDrive();
            testDrive.setAddress(req.getAddress());
            testDrive.setCarId(req.getCarId());
            testDrive.setPhone(req.getPhone());
            testDrive.setUserId(userId);
            testDriveMapper.createTestDrive(testDrive);
        }catch (Exception e){
            return RespUtil.errorResp("no such car or sql error");
        }
        return RespUtil.noDataSuccessResp();
    }

    @Override
    public Resp testDriveList(int userId, int offset, int limit) {
        Resp resp=new Resp();
        try{
            List<TestDrive> list=testDriveMapper.getTestDrivesByUserId(userId,limit,limit*(offset-1));
            List<TestDriveResp> respList=new ArrayList<>();
            for(TestDrive item:list){
                TestDriveResp testDriveResp=new TestDriveResp(item);
                testDriveResp.setCar(carMapper.getCarById((int) item.getCarId()));
                respList.add(testDriveResp);
            }
            TestDriveListData data=new TestDriveListData();
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
    public Resp testDriveListAll(int offset, int limit) {
        Resp resp=new Resp();
        try{
            List<TestDrive> list=testDriveMapper.getAllTestDrives(limit,limit*(offset-1));
            List<TestDriveResp> respList=new ArrayList<>();
            for(TestDrive item:list){
                TestDriveResp testDriveResp=new TestDriveResp(item);
                testDriveResp.setCar(carMapper.getCarById((int) item.getCarId()));
                respList.add(testDriveResp);
            }
            TestDriveListData data=new TestDriveListData();
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
    public Resp testDriveCancel(int userId,int id) {
        try{
            TestDrive testDrive=testDriveMapper.getTestDriveById(id);
            if(testDrive.getUserId()!=userId){
                return RespUtil.errorResp("user "+userId+" cannot delete test drive "+id);
            }
            testDriveMapper.deleteTestDrive(id);
        }catch (Exception e){
            return RespUtil.errorResp("sql error");
        }
        return RespUtil.noDataSuccessResp();
    }
}
