package com.louis296.car_sale.service;

import com.louis296.car_sale.mapper.MomentMapper;
import com.louis296.car_sale.mapper.ThumbUpMapper;
import com.louis296.car_sale.mapper.UserMapper;
import com.louis296.car_sale.model.dao.Moment;
import com.louis296.car_sale.model.dao.ThumbUp;
import com.louis296.car_sale.model.resp.MomentListData;
import com.louis296.car_sale.model.resp.MomentResp;
import com.louis296.car_sale.model.resp.Resp;
import com.louis296.car_sale.model.resp.UserResp;
import com.louis296.car_sale.util.FileUtil;
import com.louis296.car_sale.util.RespUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Service
public class MomentServiceImpl implements MomentService{

    final private MomentMapper momentMapper;
    final private UserMapper userMapper;
    final private ThumbUpMapper thumbUpMapper;

    @Autowired
    public MomentServiceImpl(MomentMapper momentMapper, UserMapper userMapper, ThumbUpMapper thumbUpMapper) {
        this.momentMapper = momentMapper;
        this.userMapper = userMapper;
        this.thumbUpMapper = thumbUpMapper;
    }


    @Override
    public Resp momentList(int userId, int offset, int limit) {
        Resp resp=new Resp();
        try{
            List<Moment> list;
            if (userId!=-1){
                list=momentMapper.getMomentsByUserId(userId,limit*(offset-1),limit);
            }else{
                list=momentMapper.getAllMoments(limit*(offset-1),limit);
            }

            List<MomentResp> respList=new ArrayList<>();
            for(Moment moment:list){
                MomentResp momentResp=new MomentResp(moment);
                momentResp.setUser(new UserResp(userMapper.getUserById((int) moment.getUserId())));
                respList.add(momentResp);
            }

            MomentListData data=new MomentListData();
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
    public Resp momentCreate(MultipartFile[] files, String context, int userId, HttpServletRequest request) {
        Resp resp=new Resp();
        try{
            StringBuffer stringBuffer=new StringBuffer();
            for(MultipartFile file:files){
                String fileName= FileUtil.saveFileToAssetWithFolderName("moment_img",file);
                if (fileName.equals("")){
                    return RespUtil.errorResp("file save error");
                }
                String url=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+"/moment_img/"+fileName;
                stringBuffer.append(url);
                stringBuffer.append(";");
            }
            stringBuffer.deleteCharAt(stringBuffer.length()-1);
            String imgUrl=stringBuffer.toString();
            Moment moment=new Moment();
            moment.setContext(context);
            moment.setImgUrl(imgUrl);
            moment.setUserId(userId);
            momentMapper.createMoment(moment);

            MomentResp data=new MomentResp(moment);
            data.setUser(new UserResp(userMapper.getUserById((int) moment.getUserId())));
            resp.setData(data);
            resp.setStatus("success");
        }catch (Exception e){
            return RespUtil.errorResp("sql error or file save error");
        }
        return resp;
    }

    @Override
    public Resp momentDelete(int momentId,int userId) {
        try{
            Moment moment=momentMapper.getMomentById(momentId);
            if(moment.getUserId()!=userId){
                return RespUtil.errorResp("moment "+moment.getId()+" cannot delete by user "+userId);
            }
            momentMapper.softDeleteMoment(momentId);
        }catch (Exception e){
            return RespUtil.errorResp("sql error");
        }
        return RespUtil.noDataSuccessResp();
    }

    @Override
    public Resp momentThumbUp(int momentId, int userId) {
        ThumbUp thumbUp=thumbUpMapper.getThumbUpByUserIdAndMomentId(userId,momentId);
        if (thumbUp!=null){
            return RespUtil.errorResp("user "+userId+" already thumb up moment "+momentId);
        }
        Moment moment=momentMapper.getMomentById(momentId);
        if(moment==null){
            return RespUtil.errorResp("no such moment");
        }
        thumbUp=new ThumbUp();
        thumbUp.setMomentId(momentId);
        thumbUp.setUserId(userId);
        thumbUpMapper.createThumbUp(thumbUp);
        momentMapper.changeMomentLike((int) (moment.getLike()+1),momentId);
        return RespUtil.noDataSuccessResp();
    }
}
