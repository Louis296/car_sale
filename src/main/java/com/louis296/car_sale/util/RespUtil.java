package com.louis296.car_sale.util;

import com.louis296.car_sale.model.resp.ErrorData;
import com.louis296.car_sale.model.resp.Resp;

public class RespUtil {
    public static Resp errorResp(String msg){
        Resp resp=new Resp();
        resp.setData(new ErrorData(msg));
        resp.setStatus("error");
        return resp;
    }
}
