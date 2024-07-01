package com.alurafood.gatewey;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@EnableEurekaClient
@ComponentScan(basePackages = {"com.alurafood"})
public class GateweyApplication {

	public static void main(String[] args) {
		SpringApplication.run(GateweyApplication.class, args);
	}

}
