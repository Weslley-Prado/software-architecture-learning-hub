package com.weslleyprado.restapiapplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class RestApiApplicationClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestApiApplicationClientApplication.class, args);
	}

}
