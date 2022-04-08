package com.louis296.car_sale.aspect;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.louis296.car_sale.CarSaleApplication;
import com.louis296.car_sale.mapper.UserMapper;
import com.louis296.car_sale.model.dao.User;
import com.louis296.car_sale.model.resp.ErrorData;
import com.louis296.car_sale.model.resp.Resp;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
public class LoginAspect {

    private final UserMapper userMapper;

    @Autowired
    public LoginAspect(UserMapper userMapper){
        this.userMapper=userMapper;
    }

    @Around("execution(* com.louis296.car_sale.controller..*.*(..))  " +
            "&& !execution(* com.louis296.car_sale.controller.UserController.userLogin(..)) " +
            "&& !execution(* com.louis296.car_sale.controller.UserController.userRegister(..))")
    public Object doLoginCheck(ProceedingJoinPoint joinPoint) throws Throwable{
        Object result;
        try{
            Object[] args=joinPoint.getArgs();
            HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
            String token = request.getHeader("Authorize");
            JWTVerifier jwtVerifier= JWT.require(Algorithm.HMAC256(CarSaleApplication.secret)).build();
            DecodedJWT decodedJWT=jwtVerifier.verify(token);
            String userId=decodedJWT.getClaim("aud").asString();
            User user=userMapper.getUserByUserId(userId);
            for (Object argParam:args){
                if (argParam instanceof User){
                    User userParam=(User) argParam;
                    userParam.setType(user.getType());
                    userParam.setUserName(user.getUserName());
                }
            }
            result=joinPoint.proceed(args);
        }catch (Exception e){
            Resp resp=new Resp(new ErrorData("no jwt token or token invalid"));
            resp.setStatus("Error");
            result= resp;
        }
        return result;
    }
}

