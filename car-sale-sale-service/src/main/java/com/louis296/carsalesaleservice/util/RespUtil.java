package com.louis296.carsalesaleservice.util;

import com.louis296.carsalesaleservice.model.resp.ErrorData;
import com.louis296.carsalesaleservice.model.resp.Resp;

public class RespUtil {
    public static Resp errorResp(String msg){
        Resp resp=new Resp();
        resp.setData(new ErrorData(msg));
        resp.setStatus("error");
        return resp;
    }

    public static Resp noPermissionResp(){
        Resp resp=new Resp();
        resp.setData(new ErrorData("not enough permission"));
        resp.setStatus("error");
        return resp;
    }

    public static Resp noDataSuccessResp(){
        Resp resp=new Resp();
        resp.setStatus("success");
        return resp;
    }
}
