package com.louis296.carsalegateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class CarSaleGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(CarSaleGatewayApplication.class, args);
	}

}
