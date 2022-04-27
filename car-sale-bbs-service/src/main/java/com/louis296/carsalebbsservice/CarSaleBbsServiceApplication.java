package com.louis296.carsalebbsservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class CarSaleBbsServiceApplication {
	public static String secret="DKJfioeef390jfsldnf";
	public static String salt="ewr23-kl2jsdf;f0-320-";

	public static void main(String[] args) {
		SpringApplication.run(CarSaleBbsServiceApplication.class, args);
	}

}
