package com.louis296.car_sale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CarSaleApplication {

    public static String secret="DKJfioeef390jfsldnf";
    public static String salt="ewr23-kl2jsdf;f0-320-";

    public static void main(String[] args) {
        SpringApplication.run(CarSaleApplication.class, args);
    }

}
