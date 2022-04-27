package com.louis296.carsaleeurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class CarSaleEurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CarSaleEurekaServerApplication.class, args);
	}

}
